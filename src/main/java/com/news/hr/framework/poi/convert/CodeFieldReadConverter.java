package com.news.hr.framework.poi.convert;

import com.news.hr.framework.poi.exception.ExcelKitReadConverterException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeFieldReadConverter implements ReadConverter {

    /**
     * 读取单元格时，将值进行转换（将名称编码转成编码，例如：利润指标(ZB-1057)转成ZB-1507）
     */
    @Override
    public Object convert(Object o) throws ExcelKitReadConverterException {
    	if(o==null) {
    		return null;
    	}
        String value = (String) o;
        String convertedValue = "";
        if(StringUtils.isNotEmpty(value)){
            convertedValue = getCode(value);
        }

        return convertedValue;
    }

    private String getCode(String s) {
        Matcher mat = Pattern.compile("(?<=\\()(\\S+)(?=\\))").matcher(s);
        while(mat.find()) {
            return mat.group();
        }
        return "";
    }
}