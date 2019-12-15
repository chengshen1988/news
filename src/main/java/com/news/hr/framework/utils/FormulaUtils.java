package com.news.hr.framework.utils;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FormulaUtils {
	public static final String 模块奖金="模块奖金";
	public static final String 订单分数="订单分数";
	public static final String 评分平均="评分平均";
	public static final String 评分求和="评分求和";
	
	private static JexlEngine JEXL = new JexlEngine();
	static {
		getInstance();
		JEXL.setCache(512);
        JEXL.setLenient(false);
        JEXL.setSilent(false);
	}
	private static Map<String,String> conditonmap;
	private static Map<String,Object> testmap;
	static {
		conditonmap = new HashMap();
		conditonmap.put("实际完成值", "actualComplete");
		conditonmap.put("基本目标", "basicTarget");
		conditonmap.put("提升目标", "improveTarget");
		conditonmap.put("奋斗目标", "struggleTarget");
		conditonmap.put("默认分值", "scoreDefault");
		conditonmap.put("月数", "month");
		conditonmap.put("指标权重", "quotaWeight");
		
		conditonmap.put("指标得分", "score");
		conditonmap.put("得分修正值", "resultRevision");
		conditonmap.put("考评组权重", "assessGroupWeight");
		
		conditonmap.put("专业模块分数", "zymkfs");
		conditonmap.put("奖金基数", "jjjs");
		conditonmap.put("计奖人数", "jjrs");
		conditonmap.put("单位系数", "dwxs");
		conditonmap.put("兑现比例", "dxbl");
		conditonmap.put("管理责任系数", "glzrxs");
		conditonmap.put("奖罚金额求和", "jfjeqh");
		conditonmap.put("算数求和[奖罚金额]", "jfjeqh");
	}
	static {
		testmap = new HashMap();
		testmap.put("实际完成值", 1);
		testmap.put("基本目标", 2);
		testmap.put("提升目标", 3);
		testmap.put("奋斗目标", 4);
		testmap.put("默认分值", 5);
		testmap.put("月数", 6);
		testmap.put("指标权重", 7);
		
		testmap.put("专业模块分数", 8);
		testmap.put("奖金基数", 9);
		testmap.put("计奖人数", 10);
		testmap.put("单位系数", 11);
		testmap.put("兑现比例", 12);
		testmap.put("管理责任系数", 13);
		testmap.put("奖罚金额求和", 14);
		testmap.put("算数求和[奖罚金额]", 15);
	}
	public static boolean validate(String exp) {
		Object re = null;
		for(String key:testmap.keySet()) {
			exp = exp.replace(key, String.valueOf(testmap.get(key)));
		}
		try {
			Expression expression = getInstance().createExpression(exp);
			JexlContext jc = new MapContext();
			re = expression.evaluate(jc)==null?0:expression.evaluate(jc);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		if(re==null) {
			return false;
		}
		return true;
	}
	
	private static JexlEngine getInstance() {
		if(JEXL==null) {
			JEXL = new JexlEngine();
		}
		return JEXL;
	}
	public static BigDecimal calc(String exp,Map<String,Object> map) {
		if(StringUtils.isEmpty(exp) || map==null) {
			return new BigDecimal(String.valueOf(0));
		}
		for(String key:conditonmap.keySet()) {
			exp = exp.replace(key, conditonmap.get(key));
		}
		Expression expression = getInstance().createExpression(exp);
		JexlContext jc = new MapContext();
		map.keySet().stream().forEach(key->{
			jc.set(key, map.get(key));
		});
		
		Object re = expression.evaluate(jc)==null?0:expression.evaluate(jc);
		return new BigDecimal(String.valueOf(re));
	}
	
	public static void main(String args[]) {
		String exp = "实际完成值/基本目标>=1 and 实际完成值/基本目标<1.6	";
		boolean re = validate(exp);
		System.err.println("======re:"+re);
	}
}
