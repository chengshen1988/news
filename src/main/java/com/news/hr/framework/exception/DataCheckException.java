package com.news.hr.framework.exception;

/**
 * 描述： 数据校验异常
 * 
 * @author zhangbaofeng1022@sina.com
 * @version 创建时间：2018年3月16日 上午11:43:20
 */
public class DataCheckException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 95478418837203456L;

	public DataCheckException(String message) {
		super(message);
	}
	public DataCheckException(Throwable e) {
		super(e);
	}

	public DataCheckException(String message, Throwable e) {
		super(message, e);
	}
	
}
