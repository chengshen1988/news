package com.news.hr.common.controller;


import com.news.hr.common.service.RedisService;
import com.news.hr.framework.config.security.JwtTokenUtil;
import com.news.hr.framework.config.security.entity.AuthenticationRequest;
import com.news.hr.framework.config.security.entity.AuthenticationResponse;
import com.news.hr.framework.config.security.entity.UserPrincipal;
import com.news.hr.framework.exception.AuthenticationException;
import com.news.hr.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ChenSeen
 */
@Slf4j
@Api(value = "系统管理-鉴权接口", tags = {"系统管理-鉴权接口"})
@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;

    @ApiOperation("登录")
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(HttpServletRequest request, AuthenticationRequest authenticationRequest) throws AuthenticationException {
    	String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("User is disabled!", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Bad credentials!", e);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String token = jwtTokenUtil.generateToken(userPrincipal);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

}
