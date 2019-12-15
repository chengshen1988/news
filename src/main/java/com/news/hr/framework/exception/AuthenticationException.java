package com.news.hr.framework.exception;

/**
 * @author ChenSeen
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
