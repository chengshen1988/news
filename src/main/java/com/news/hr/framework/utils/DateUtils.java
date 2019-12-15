package com.news.hr.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	/**
	 * @Title: getTime
	 * @Description: 获取标准的日期时间格式
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String getStringTime() {
		Date date = new Date();
		return getStringTime(date);
	}

	/**
	 * @Title: getStringTime
	 * @Description: 获取标准的日期时间格式
	 * @param @param date
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String getStringTime(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}

	/**
	 * @Title: getDate
	 * @Description: 获取标准的日期格式
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String getStringDate() {
		Date date = new Date();
		return getStringDate(date);
	}

	/**
	 * @Title: getStringDate
	 * @Description: 获取标准的日期格式
	 * @param @param date
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String getStringDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}

	/**
	 * @Title: getStringDate
	 * @Description: 获取标准的日期格式
	 * @param @param date
	 * @param @param format 格式
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String getStringDate(Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	public static Date getDate() {
		return new Date();
	}

	/**
	 * @Title: parseDate
	 * @Description: 将字符串转换成日期，支持以下格式{"yyyy-MM","yyyyMM","yyyy/MM", "yyyyMMdd","yyyy-MM-dd","yyyy/MM/dd", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss"}
	 * 如果不在这些格式中，返回null
	 * @param @param stringDate
	 * @param @return    设定文件
	 * @return Date    返回类型
	 * @throws
	 */
	public static Date parseDate(String stringDate) {
		String[] pattern = new String[] { "yyyy-MM", "yyyy/MM", "yyyyMMdd", "yyyyMM", "yyyy-MM-dd", "yyyy/MM/dd", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss",
				"yyyy" };
		Date date = null;
		try {
			date = parseDate(stringDate, pattern);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	/**
	 * @Title: getYear
	 * @Description: 获取当前年份
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String getYear() {
		String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		return year;
	}

	/**
	 * @Title: getMonth
	 * @Description: 获取当前月份
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String getMonth() {
		String month = Integer.toString(Calendar.getInstance().get(Calendar.MONTH));
		return month;
	}

	/**
	 * @Title: getDay
	 * @Description: 获取当前日
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String getDay() {
		String day = Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		return day;
	}

	/**
	 * @Title: getYear
	 * @Description: 获取当前年份
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static int getIntYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**
	 * @Title: getLastMonthYear
	 * @Description: 获取上一个月年份
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getLastMonthYear() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		Date m = c.getTime();
		String mon = format.format(m);
		return mon;
	}
	/**
	 * @Title: getLastMonthMonth
	 * @Description: 获取上一个月月份
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getLastMonthMonth() {
		SimpleDateFormat format = new SimpleDateFormat("MM");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		Date m = c.getTime();
		String mon = format.format(m);
		return mon;
	}
	/**
	 * @Title: getMonth
	 * @Description: 获取当前月份
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static int getIntMonth() {
		return Calendar.getInstance().get(Calendar.MONTH);
	}

	/**
	 * @Title: getDay
	 * @Description: 获取当前日
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static int getIntDay() {
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * @Title: getSimpleYear
	 * @Description: 获取当前年份后两位
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String getSimpleYear() {
		String simpleYear = new SimpleDateFormat("yy", Locale.CHINESE).format(Calendar.getInstance().getTime());
		return simpleYear;
	}

	/**
	 * @Title: getYearMonth
	 * @Description: 获取当前年份加月份
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String getYearMonth() {
		String yearMonth = new SimpleDateFormat("yyyyMM", Locale.CHINESE).format(Calendar.getInstance().getTime());
		return yearMonth;
	}

	/**
	 * @Title: pastDays
	 * @Description: 计算距离目前时间过去了多少天
	 * @param @param date
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / 86400000L;
	}

	/**
	 * @Title: pastHours
	 * @Description: 计算距离目前时间过去了多少小时
	 * @param @param date
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public static long pastHours(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / 3600000L;
	}

	/**
	 * @Title: pastMinutes
	 * @Description: 计算距离今天过去了多少分钟
	 * @param @param date
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / 60000L;
	}

	/**
	 *
	 * @Title: formatTimeDifference
	 * @Description: 根据毫秒数获取时间差，并格式化成天时分秒毫秒格式
	 * @param @param timeMillis
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String formatTimeDifference(long timeMillis) {
		long day = timeMillis / 86400000L;
		long hour = timeMillis / 3600000L - day * 24L;
		long min = timeMillis / 60000L - day * 24L * 60L - hour * 60L;
		long s = timeMillis / 1000L - day * 24L * 60L * 60L - hour * 60L * 60L - min * 60L;
		long sss = timeMillis - day * 24L * 60L * 60L * 1000L - hour * 60L * 60L * 1000L - min * 60L * 1000L - s * 1000L;
		return (day > 0L ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}

	public static Date getAfterDays(int days) {
		return getAfterDays(new Date(), days);
	}
	/**
	 *
	 * @Title: getAfterDays
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param date
	 * @param @param day
	 * @param @return    设定文件
	 * @return Date    返回类型
	 * @throws
	 */
	public static Date getAfterDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

	/**
	 * 转化日期的时间格式为00时00分00秒
	 * @Title: parseLastTime
	 * @Description: 转化日期的时间格式为00时00分00秒
	 * @param sourceDate
	 * @return Date
	 */
	public static Date parseFirstTime(Date sourceDate) {
		return parseTime(sourceDate, 00, 00, 00);
	}

	/**
	 * 转化日期的时间格式为23时59分59秒
	 * @Title: parseLastTime
	 * @Description: 转化日期的时间格式为23时59分59秒
	 * @param sourceDate
	 * @return Date
	 */
	public static Date parseLastTime(Date sourceDate) {
		return parseTime(sourceDate, 23, 59, 59);
	}

	/**
	 * 转化日期的时间格式为23时59分59秒
	 * @Title: parseLastTime
	 * @Description: 转化日期的时间格式为23时59分59秒
	 * @param sourceDate
	 * @return Date
	 */
	public static String parseLastTime(String sourceDate) {
		Date date = parseDate(sourceDate);
		if (date != null) {
			Date lastDate = parseLastTime(date);
			return getStringTime(lastDate);
		}
		return sourceDate;
	}

	/**
	 *
	 * @Title: parseTime
	 * @Description: 转化日期的时间格式为自定义时分秒
	 * @param sourceDate
	 * @return Date
	 */
	public static Date parseTime(Date sourceDate, int hour, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sourceDate);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		return calendar.getTime();
	}

	/**
	 *
	 * @Title: differToDays
	 * @Description: 计算时间差值 ，返回天数
	 * @param startDate
	 * @param endDate
	 * @return Date
	 */
	public static int differToDays(Date startDate, Date endDate) {
		long start = startDate.getTime();
		long end = endDate.getTime();
		int days = (int) ((end - start) / (1000 * 60 * 60 * 24));
		long days_ = (end - start) % (1000 * 60 * 60 * 24);
		if (days_ != 0) {
			days += 1;
		}
		return start == end ? 1 : days;
	}

	/**
	 * 描述：在给定的日期加上或减去指定月份后的日期
	 *
	 * @param sourceDate 原始时间
	 * @param month 要调整的月份，向前为负数，向后为正数
	 * @return
	 */
	public static Date stepMonth(Date sourceDate, int month) {
		Calendar c = Calendar.getInstance();
		c.setTime(sourceDate);
		c.add(Calendar.MONTH, month);

		return c.getTime();
	}

	/**
	 * 描述：取得当前月的第一天
	 * @return (yyyy-MM-dd)
	 */
	public static String getFirstDayByMonth() {
		String currenDay = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);// 设为当前月的1号
		currenDay = sdf.format(calendar.getTime());
		return currenDay;
	}

	/**
	 * 描述：取得当年的第一天
	 * @return (yyyy-MM-dd)
	 */
	public static Date getFirstDayByYear() {
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR); // 获得当前年份
		return getFirstDayByYear(currentYear);
	}


	/**
	 * 描述：取得当年的第一天
	 * @return (yyyy-MM-dd)
	 */
	public static Date getFirstDayByYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year); // 获得当年的第一天
		return calendar.getTime();
	}

	/**
	 * 描述：取得当年的最后一天
	 * @return (yyyy-MM-dd)
	 */
	public static Date getLastDayByYear() {
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR); // 获得当前年份
		return getLastDayByYear(currentYear);
	}


	/**
	 * 描述：取得当年的最后一天
	 * @return (yyyy-MM-dd)
	 */
	public static Date getLastDayByYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();
		return currYearLast;
	}

	/**
	 * 获取两个日期之间的日期
	 * @param start 开始日期
	 * @param end 结束日期
	 * @return 日期集合
	 */
	private static List<String> getBetween(Date start, Date end, int step, String pattern) {
		Set<String> result = new TreeSet<String>();
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(start);

		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(end);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		while (tempStart.before(tempEnd)) {
			String dateString = simpleDateFormat.format(tempStart.getTime());
			result.add(dateString);
			tempStart.add(step, 1);
		}
		String dateString = simpleDateFormat.format(end.getTime());
		result.add(dateString);
		// set集合转换成list集合
		List<String> monthList = new ArrayList<String>(result);
		return monthList;
	}

	public static List<String> getBetweenYears(Date start, Date end) {
		return getBetween(start, end, Calendar.DAY_OF_YEAR, "yyyy");
	}

	public static List<String> getBetweenMonths(Date start, Date end) {
		return getBetween(start, end, Calendar.DAY_OF_MONTH, "yyyy-MM");
	}

	public static List<String> getBetweenDays(Date start, Date end) {
		return getBetween(start, end, Calendar.DATE, "yyyyMMdd");
	}

	/**
	 * 根据某个月份获取当前已经过去的月份
	 * @Title: getPassMonth
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param month
	 * @param @param fill0 如果小于10月是否补0显示成01
	 * @param @return    设定文件
	 * @return List<String>    返回类型
	 * @throws
	 */
	public static List<String> getPassMonth(String month, boolean fill0){
		List<String> months = new ArrayList<String>();
		int monthInt = Integer.parseInt(month);
		for (int i = 1; i <= monthInt; i++){
			String m = Integer.toString(i);
			if(fill0==true && i<10){
				m = "0" + m;
			}
			months.add(m);
		}
		return months;
	}

	public static void main(String[] args) {
//		Date date1 = parseDate("20180101");
//		Date date2 = parseDate("20181001");
//		List<String> dates = getBetweenMonths(date1, date2);
//		for (String date : dates) {
//			System.out.println(date);
//		}

		Date lastDayByYear = getLastDayByYear();
		System.out.println(lastDayByYear);
	}
}
