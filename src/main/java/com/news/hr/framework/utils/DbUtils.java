package com.news.hr.framework.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class DbUtils {

    /**
     * 根据List生成SQL中的in字符串 ('zhangsan','lisi','wangwu')
     * @param inValues
     * @return
     */
    public static String generateSqlCondition(List<String> inValues) {
        String in = "";
        if (CollectionUtils.isNotEmpty(inValues)) {
            StringBuilder inCondition = new StringBuilder();
            inCondition.append("(");
            for (String v : inValues) {
                inCondition.append("'");
                inCondition.append(v);
                inCondition.append("'");
                inCondition.append(",");
            }
            in = inCondition.toString();
            in = StringUtils.removeEnd(in, ",");
            in = in + ")";
        }
        return in;
    }

    /**
     * 根据List生成SQL中的in字符串 ('zhangsan','lisi','wangwu')
     * @param inValues
     * @return
     */
    public static String generateSqlCondition(String inValues) {
        if(StringUtils.isNotEmpty(inValues)){
            List<String> inList = Arrays.asList(inValues.split(","));
            return generateSqlCondition(inList);
        }
        return "";
    }

    /**添加自定义sql条件
     * @param criteria
     */
    public static void addCustomCondition(Object criteria, String condition) {
        Method method;
        try {
            method = criteria.getClass().getSuperclass().getDeclaredMethod("addCriterion", String.class);
            method.setAccessible(true);
            method.invoke(criteria, condition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
