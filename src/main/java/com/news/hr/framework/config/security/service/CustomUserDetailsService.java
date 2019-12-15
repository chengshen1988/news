package com.news.hr.framework.config.security.service;

import com.news.hr.common.service.RedisService;
import com.news.hr.framework.config.security.entity.UserPrincipal;
import com.news.hr.framework.config.security.entity.UserSession;
import com.news.hr.system.bean.query.UserQuery;
import com.news.hr.system.service.PermissionService;
import com.news.hr.system.service.RoleService;
import com.news.hr.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 自定义UserDetails查询
 * </p>
 *
 * @package: com.xkcoding.rbac.security.service
 * @description: 自定义UserDetails查询
 * @author: yangkai.shen
 * @date: Created in 2018-12-10 10:29
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RedisService redisService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPrincipal userPrincipal = null;
        if (userPrincipal == null) {
            final UserQuery userQuery = UserQuery.builder()
                    .username(username)
                    .build();
            final UserSession userSession = userService.getUserSession(userQuery);
            if (userSession != null){
                userPrincipal = UserPrincipal.create(userSession);
                redisService.set(username, userPrincipal, 30, TimeUnit.MINUTES);
            }else {
                throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
            }
        }
        return userPrincipal;
    }
}
