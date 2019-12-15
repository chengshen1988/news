package com.news.hr.framework.exception;

/**
 * 
* @ClassName: CheckUniqueFailureException 
* @Description: 唯一性验证失败异常
* @author daoan.guo@pcitc.com
* @date 2018年2月22日 下午3:59:59 
*
 */
public class CheckUniqueFailureException extends BaseException {
	private static final long serialVersionUID = 1L;

	public CheckUniqueFailureException(String message) {
        super(message);
    }
}
