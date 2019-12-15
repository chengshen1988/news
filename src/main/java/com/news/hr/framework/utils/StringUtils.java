package com.news.hr.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
* @ClassName: StringUtils 
* @Description: 字符串工具类，继承自apache的StringUtils
* @author guodaoan
* @date 2014年11月15日 下午4:24:51 
*  
*/
public class StringUtils extends org.apache.commons.lang3.StringUtils{

	private static Logger logger = LoggerFactory.getLogger(StringUtils.class);
	/** 
	* @Title: addBeforeAfter 
	* @Description: 给字符串加前缀后缀
	* @param str
	* @param before
	* @param after
	* @return  String    返回类型 
	* @throws 
	*/
	public static String addBeforeAfter(String str, String before, String after){
		if(isEmpty(before))
			before = "";
		if(isEmpty(after))
			after = "";
		if(isEmpty(str))
			return before + after;
		return before + str + after;
	}
	
	/** 
	* @Title: joinComma 
	* @Description: 给总的字符串加上子字符串，以逗号分隔
	* @param sum
	* @param sub
	* @return  String    返回类型 
	* @throws 
	*/
	public static String joinString(String sum, String sub){
		return joinString(sum, sub, ",");
	}
	
	/** 
	* @Title: joinComma 
	* @Description: 给总的字符串加上子字符串，以join分隔
	* @param sum
	* @param sub
	* @param join
	* @return  String    返回类型 
	* @throws 
	*/
	public static String joinString(String sum, String sub, String join){
		if(isEmpty(sum))
			sum = "";
		if(isEmpty(sub))
			return sum;
		if(sum.length()==0)
			return sum + sub;
		else
			return sum + join + sub;
	}
	
	/** 
	* @Title: joinComma 
	* @Description: 给总的字符串加上子字符串，以逗号分隔
	* @return  String    返回类型
	* @throws 
	*/
	public static String removeLastComma(String string){
		if(string==null)
			return null;
		if(isEmpty(string))
			return "";
		if(string.endsWith(","))
			return string.substring(0, string.length()-1);
		else
			return string;
	}
	
	/** 
	 * @Title: replaceBlank 
	 * @Description: 去掉字符串中的空格、回车、换行符、制表符
	 * @param str
	 * @return  String
	 */
	public static String replaceBlank(String str){
		String dest = "";         
		if (str!=null) {             
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");             
			Matcher m = p.matcher(str);             
			dest = m.replaceAll("").replaceAll("�","");         
		}         
		return dest; 
	}
	
	/** 
	 * @Title: replaceLast 
	 * @Description: 
	 * @param regix
	 * @param replacement
	 * @return  String
	 */
	public static String replaceLast(String target, String regix, String replacement) {
		int pos = target.lastIndexOf(regix);
		if (pos > -1) {
			return target.substring(0, pos)
		    + replacement
		    + target.substring(pos + regix.length(), target.length());
		 } else {
			 return target;
		 }
	}
	
	/** 
	 * @Description: 判断字符串是否为空
	 */
	public static boolean isNullOrEmpty(String str) {
		if(str == null || str.trim().equals("")) return true;
		
		return false;
	}
	/**
	* @Title: split2SqlIn 
	* @Description: 逗号分隔的多ID字符串转换成Sql语句中的In——"1001,1002"转未"'1001','1002'"
	* @param @param ids
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String split2SqlIn(String ids){
		if(isNullOrEmpty(ids)){
			return "''";
		}
		String sqlIn = "";
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++){
			String id = idsArray[i];
			id = addBeforeAfter(id, "'", "'");
			sqlIn = joinString(sqlIn, id);
		}
		return sqlIn;
	}

	/**
	* @Title: underlineToCamel 
	* @Description: 下划线转驼峰命名  USER_ID转换为userId
	* @param @param param
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String underlineToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == '_') {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(Character.toLowerCase(c));
			}
		}
		return sb.toString();
	}

	/**
	 * @Title: underlineToCamel
	 * @Description: 下划线转驼峰命名  USER_ID转换为userId
	 * @param @param param
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String mlineToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == '-') {
					sb.append("_");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	/**
	* @Title: camelToUnderline 
	* @Description: 驼峰转下划线命名  
	* @param @param param
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */

	public static String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append('_');
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	* @Title: current 
	* @Description: 传一个数字字符串，返回当前格式化的值，如果不足size大小，则在前面补padding字符串
	* @param @param num
	* @param @param size
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String current(String num, int size, String padding){
		if(StringUtils.isNullOrEmpty(num)){
			num = "0";
		}
		Integer number = Integer.parseInt(num);
		String current = leftPad(number.toString(), size, padding);
		return current;
	}
	
	/**
	* @Title: next 
	* @Description: 传一个数字字符串，返回+1的值，如果不足size大小，则在前面补padding字符串
	* @param @param num
	* @param @param size
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String next(String num, int size, String padding){
		if(StringUtils.isNullOrEmpty(num)){
			num = "0";
		}
		Integer number = Integer.parseInt(num);
		number++;
		String next = leftPad(number.toString(), size, padding);
		return next;
	}
	
	/**
	 * 
	* @Title: inRange 
	* @Description: 判断字符串是否在两个字符串区间
	* @param @param s
	* @param @param min
	* @param @param max
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean inRange(String s, String min, String max){
		return s.compareTo(max) < 0 && s.compareTo(min) > 0;
	}
	/**
	* @Title: current 
	* @Description: 传一个数字字符串，返回当前值格式化，如果不足size大小，则在前面补0
	* @param @param num
	* @param @param size
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String current(String num, int size){
		return current(num, size, "0");
	}
	/**
	* @Title: next 
	* @Description: 传一个数字字符串，返回+1的值，如果不足size大小，则在前面补0
	* @param @param num
	* @param @param size
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String next(String num, int size){
		return next(num, size, "0");
	}
	/**
	* @Title: next 
	* @Description: 传一个数字字符串，取右边size长度大小的整数+1的值，再加上左面字符串的值，传递[CHINA001]，返回[CHINA002]
	* @param @param num
	* @param @param size
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String nextString(String string, int size){
		String num = right(string, size);
		String nextNum = next(num, size);
		String prefix = left(string, string.length()-size);
		return prefix+nextNum;
	}
	/**
	 * @Author
	 * @Description
	 * @Date 13:00 2018/12/7
	 * @Param [list]
	 * @return java.lang.String
	 **/
	public static String toString(List<Object> list){
		StringBuffer sb = new StringBuffer();
		String string = "";
		if(list!=null && list.size()>0){
			sb.append("[");
			for(Object o : list){
				sb.append(o.toString());
				sb.append(",");
			}
			string = sb.toString();
			string = removeLastComma(string);
			string = string + "]";
		}
		return string;
	}
	/**
	 * @Author
	 * @Description
	 * @Date 13:00 2018/12/7
	 * @Param [list]
	 * @return java.lang.String
	 **/
	public static String toString(Object[] list){
		StringBuffer sb = new StringBuffer();
		String string = "";
		if(list!=null && list.length>0){
			sb.append("[");
			for(Object o : list){
				sb.append(o.toString());
				sb.append(",");
			}
			string = sb.toString();
			string = removeLastComma(string);
			string = string + "]";
		}
		return string;
	}
	/**
	 * @Author
	 * @Description
	 * @Date 13:03 2018/12/7
	 * @Param []
	 * @return java.lang.String
	 **/
	public static String randomUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * @Author
	 * @Description 首字母大写
	 * @Date 13:03 2018/12/7
	 * @Param [name]
	 * @return java.lang.String
	 **/
	public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
       return  name;
      
    }

	/**
	 * @Author zhangbaofeng
	 * @Description 根据多种场景处理中文乱码问题
	 * @Date 10:52 2018/12/7
	 * @Param [fileName]
	 * @return java.lang.String
	 **/
	public static String encodingCode(String code) {
		logger.info("Don't support this encoding ...");
		if (logger.isWarnEnabled()) {
			logger.info("Don't support this encoding ...222");
		}
		String returnFileName = "";
		try {
			returnFileName = URLEncoder.encode(code, "UTF-8");
			returnFileName = StringUtils.replace(returnFileName, "+", "%20");
			if (returnFileName.length() > 150) {
				returnFileName = new String(code.getBytes("GB2312"), "ISO8859-1");
				returnFileName = StringUtils.replace(returnFileName, " ", "%20");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			if (logger.isWarnEnabled()) {
				logger.info("Don't support this encoding ...");
			}
		}
		return returnFileName;
	}
	public static void main(String[] args) {
		System.out.println(camelToUnderline("createUnitId"));
		//System.out.println(underlineToCamel("'waste_demand_id','waste_demand_row_id','fjczxq_ddh','fjczxq_hth','fjczxq_khmc','fjczxqdd_bdw','fjczxqdd_gjsmc','fjczxqdd_fjxh','fjczxqdd_zz', 'fjjjmx_ypmc','fjjjmx_thrq','fjjjmx_fjjz', 'hslqrmx_gjshl','hslqrmx_gjsssl','hslqrmx_hslqy','hslqrmx_khsgjssl','fyqrjghgf_jgfdjqy','fyqrjghgf_jgf', 'waste_purchase_id','fjwtjg_wtjgddh','fjwtjg_jgf','fjwtjg_bzf','fjwtjgmx_sjhsl','fjwtjgmx_sjhsgjssl','fjwtjgmx_jgfdj','fjwtjgmx_jgfhj'"));
	}
}
