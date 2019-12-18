package com.news.hr;

import com.google.common.collect.Lists;
import org.jasypt.util.text.BasicTextEncryptor;

import java.util.ArrayList;

/**
 * @author ChenSeen
 * @Date 2019/10/27 19:38
 */
public class JasyptTest {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("hr!@#$");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("ChengS#1988");
        System.out.println("username:"+username);
        System.out.println("password:"+password);



    }


}
