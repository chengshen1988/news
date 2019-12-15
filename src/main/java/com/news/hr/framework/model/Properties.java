package com.news.hr.framework.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ChenSeen
 */
@Component
public class Properties {

    public static String port;

    /**
     *  OSS
     */
    public static String endpoint;
    public static String bucket;
    public static String accessKeyId;
    public static String accessKeySecret;


    @Value("${oss.endpoint}")
    public void setEndpoint(String endpoint) {
        Properties.endpoint = endpoint;
    }

    @Value("${oss.bucket}")
    public void setBucket(String bucket) {
        Properties.bucket = bucket;
    }

    @Value("${oss.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        Properties.accessKeyId = accessKeyId;
    }

    @Value("${oss.accessKeySecret}")
    public void setAccessKeySecret(String accessKeySecret) {
        Properties.accessKeySecret = accessKeySecret;
    }

    @Value("${server.port}")
    public void setPort(String port) {
        Properties.port = port;
    }



}