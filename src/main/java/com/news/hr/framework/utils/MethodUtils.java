package com.news.hr.framework.utils;

import com.news.hr.framework.exception.BaseException;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodUtils {
	
	public static Object invoke(Class cls,String methodName,Class[] paramClasses,Object[] param) {
		Object obj = null;
		try {
			Object bean = SpringUtils.getBean(cls);
			Method method = ReflectionUtils.findMethod(bean.getClass(), methodName, paramClasses);
			method.setAccessible(true);
			obj = ReflectionUtils.invokeMethod(method, bean, param);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("反射执行方法失败!");
		}
		
		return obj;
	}
	
	public static Object getFieldVal(Object obj,String fieldName) {
		Field field = ReflectionUtils.findField(obj.getClass(), fieldName);
		if(field==null) {
			return null;
		}
		field.setAccessible(true);
		return ReflectionUtils.getField(field, obj);
	}
	
	public static void setFieldVal(Object obj,String fieldName,Object val) {
		Field field = ReflectionUtils.findField(obj.getClass(), fieldName);
		if(field==null) {
			return;
		}
		field.setAccessible(true);
		ReflectionUtils.setField(field, obj, val);
	}
}
