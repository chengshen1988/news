package com.news.hr.framework.exception;

public class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }
    public BaseException(Throwable e){
    	super(e);
    }
    public BaseException(String message, Throwable e){
    	super(message, e);
    }
}
