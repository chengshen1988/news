package com.news.hr.framework.web.handler;

import com.news.hr.framework.exception.AuthenticationException;
import com.news.hr.framework.exception.CheckUniqueFailureException;
import com.news.hr.framework.exception.DataCheckException;
import com.news.hr.framework.model.Code;
import com.news.hr.framework.model.ReturnModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ChenSeen
 */
@RestController
@ControllerAdvice
public class RestExceptionHandler {
	
	
	private static Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public Object methodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException ex){
		StringBuilder sb = new StringBuilder();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		for(FieldError error :fieldErrors){
			sb.append(error.getDefaultMessage()+";");
		}
		logError(req, ex, false);
	    return	ReturnModel.newFailureInstance(Code.$1101_PARAMETER_ERROR, sb.toString());
	}
	
	
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Object bindException(HttpServletRequest req, BindException ex){
		StringBuilder sb = new StringBuilder();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		for(FieldError error :fieldErrors){
			sb.append(error.getDefaultMessage()+";");
		}
		
		logError(req, ex, false);
	    return	ReturnModel.newFailureInstance(Code.$1101_PARAMETER_ERROR, sb.toString());
	}
	
	
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	@ResponseBody
	public Object missingServletRequestParameterErrorHandler(HttpServletRequest req, MissingServletRequestParameterException e) throws Exception {
		logError(req, e, false);
		return ReturnModel.newFailureInstance(Code.$1101_PARAMETER_ERROR, e.getMessage());
	}

	@ExceptionHandler(value = CheckUniqueFailureException.class)
	@ResponseBody
	public Object checkUniqueFailureErrorHandler(HttpServletRequest req, CheckUniqueFailureException e) throws Exception {
		logError(req, e, false);
		return ReturnModel.newFailureInstance(Code.$1501_DATA_CHECK_ERROR, e.getMessage());
	}
	
	@ExceptionHandler(value = DataCheckException.class)
	@ResponseBody
	public Object dateCheckFailureErrorHandler(HttpServletRequest req, DataCheckException e) throws Exception {
		logError(req, e, false);
		return ReturnModel.newFailureInstance(Code.$1501_DATA_CHECK_ERROR, e.getMessage());
	}
	
	@ExceptionHandler(value = UsernameNotFoundException.class)
	@ResponseBody
	public Object UsernameNotFoundException(HttpServletRequest req, UsernameNotFoundException e) throws Exception {
		logError(req, e, false);
		return ReturnModel.newFailureInstance(Code.$1501_DATA_CHECK_ERROR, e.getMessage());
	}
	
	@ExceptionHandler(value = AuthenticationException.class)
	@ResponseBody
	public Object AuthenticationException(HttpServletRequest req, AuthenticationException e) throws Exception {
		logError(req, e, false);
		return ReturnModel.newFailureInstance(Code.$1501_DATA_CHECK_ERROR, "用户名或密码错误");
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Object defaultErrorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception {
		logError(req, e, true);
//		res.setStatus(500);
		ReturnModel returnModel = ReturnModel.newFailureInstance(Code.$1000_EXCEPTION, "系统错误，请联系管理员");
		return returnModel;
	}

	protected void logError(HttpServletRequest req, Exception e, boolean printStackTrace) {
		StringBuilder sb = new StringBuilder();
		sb.append(e.getMessage());
		sb.append("Class {");
		sb.append(e.getClass().getName());
		sb.append("} ");
		sb.append("Host {");
		sb.append(req.getRemoteHost());
		sb.append("} ");
		sb.append("invokes url {");
		sb.append(req.getRequestURL());
		sb.append("} ");
		logger.error(sb.toString());
		if (printStackTrace) {
			logger.error(e.getMessage(), e);
		}
	}
	
	
}
