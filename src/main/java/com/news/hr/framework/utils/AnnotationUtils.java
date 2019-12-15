package com.news.hr.framework.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * @Title: AnnotationUtils.java 
 * @Package com.pcitc.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 6469536@qq.com   
 * @date 2016年5月27日 下午5:29:56 
 * @version V1.0   
 */
public class AnnotationUtils<T> {

	public static <T extends Annotation> Map<String, T> getClassFieldToAnnotation(Class<?> clazz, Class<T> annotation) {
		Map<String, T> autoColumnGenerated = new HashMap<String, T>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			T anno = field.getAnnotation(annotation);
			if(anno!=null){
				autoColumnGenerated.put( field.getName(), anno);
			}
		}
		return autoColumnGenerated;
	}
	public static void main(String[] args) {}
}
