package com.news.hr.framework.utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class WebUtils {

    public static boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }

    public static void writeJson(HttpServletResponse response, Object ret) {
        PrintWriter out = null;
        try {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            String retString = new Gson().toJson(ret);
            out = response.getWriter();
            out.print(retString);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException("写入响应失败", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (servletRequestAttributes != null) {
            request = servletRequestAttributes.getRequest();
        }
        return request;
    }

    /**
     * @return javax.servlet.http.HttpServletResponse
     * @Author zhangbaofeng
     * @Description
     * @Date 17:04 2018/12/7
     * @Param []
     **/
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = null;
        if (servletRequestAttributes != null) {
            response = servletRequestAttributes.getResponse();
        }
        return response;
    }

    public static String getIpAddress(){
        HttpServletRequest request = getRequest();
        return getIpAddress(request);
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(ip.equals("127.0.0.1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ip != null && ip.length() > 15){
            if(ip.indexOf(",")>0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }
        return ip;
    }

    public static String addParam(String url, String key, String value) {
        if (url.indexOf("?") == -1) {
            url = url + "?" + key + "=" + value;
        } else {
            url = url + "&" + key + "=" + value;
        }
        return url;
    }

    public static String getParam(String url, String name) {
        String value = "";
        String paramString = url.substring(url.indexOf("?") + 1);
        Matcher match = Pattern.compile("(^|&)" + name + "=([^&]*)").matcher(paramString);
        if (match != null) {
            match.lookingAt();
            value = match.group(2);
        }
        return value;
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
//    public static JwtUser getCurrentUser() {
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        Authentication authentication = securityContext.getAuthentication();
//        JwtUser principal = null;
//        try {
//            principal = (JwtUser) authentication.getPrincipal();
//        } catch (Exception e) {
//
//        }
//        return principal;
//    }
//
//    public static UserVo getSessionUser() {
//        JwtUser jwtUser = getCurrentUser();
//        return UserConverter.convertToUserVoByJwtUser(jwtUser);
//    }

    /**
     * 获取当前登录用户名
     *
     * @return
     */
//    public static String getCurrentUsername() {
//        return getCurrentUser().getUsername();
//    }




    public static String encode(String text, String charset) {
        try {
            return URLEncoder.encode(text, charset);
        } catch (UnsupportedEncodingException e) {
            log.error(" text -> {}, charset -> {} decode error, message is -> {} ", text, charset, e.getMessage());
        }
        return null;
    }

    public static String encode(String text) {
        return encode(text, "UTF-8");
    }

    public static String decode(String text, String charset) {
        try {
            return URLDecoder.decode(text, charset);
        } catch (UnsupportedEncodingException e) {
            log.error(" text -> {}, charset -> {} encode error, message is -> {} ", text, charset, e.getMessage());
        }
        return null;
    }

    public static String decode(String text) {
        return decode(text, "UTF-8");
    }

}
