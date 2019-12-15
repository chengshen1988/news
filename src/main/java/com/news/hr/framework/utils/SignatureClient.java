package com.news.hr.framework.utils;

import com.news.hr.framework.exception.BaseException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class SignatureClient {
	private static final String HMAC_SHA1 = "HMACSHA1";

	public SignatureClient() {
	}

	public static Map<String, String> hmacSignature(String AK, String SK, String content) {
		Map<String, String> returnMap = new HashMap();

		Date now = new Date();
		String gmtdate = getGMT(now);

		String content_Md5 = "";
		try {
			content_Md5 = EncoderByMd5(content);
		} catch (Exception e) {
			throw new BaseException("Content MD5 Failed");
		}

		String signature = "";
		String signstring = "date: " + gmtdate + "\ncontent-md5: " + content_Md5;
		try {
			signature = getSignature(signstring, SK);
		} catch (Exception e) {
			throw new BaseException("SK signature Failed");
		}

		String auth = "hmac accesskey=\"" + AK
				+ "\", algorithm=\"hmac-sha1\", headers=\"date content-md5\", signature=\"" + signature + "\"";

		returnMap.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		returnMap.put("Authorization", auth);
		returnMap.put("Date", gmtdate);
		returnMap.put("Content-md5", content_Md5);

		return returnMap;
	}

	private static String getGMT(Date dateCST) {
		DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		return df.format(dateCST);
	}

	private static String EncoderByMd5(String str) throws Exception {
		String md5Str = DigestUtils.md5Hex(str);
		String base64_str = Base64.encodeBase64String(md5Str.getBytes("utf-8"));
		return base64_str;
	}

	private static String getSignature(String data, String key) throws Exception {
		byte[] keyBytes = key.getBytes("utf-8");
		SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HMACSHA1");
		DigestUtils.sha1Hex(key.getBytes("utf-8"));
		Mac mac = Mac.getInstance("HMACSHA1");
		mac.init(signingKey);
		byte[] rawHmac = mac.doFinal(data.getBytes());

		String base64_str = Base64.encodeBase64String(rawHmac);
		return base64_str;
	}
}