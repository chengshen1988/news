package com.news.hr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class newsUnionApplicationTests {

//    @Autowired
//    NoticeService noticeService;

    @Test
    public void contextLoads() {
//        ArrayList<Notice> notices = new ArrayList<>();
//        for (int i = 0; i < 200; i++) {
//            Notice notice = new Notice();
//            notice.setDataorder(new Random().nextInt());
//            notice.setMuserid("123456");
//            notice.setMusername("chen seen");
//            notice.setMtime(LocalDateTime.now());
//            notice.setOrgCode("056400");
//            notice.setNoticeType("岗位条例");
//            notice.setNoticeTitle("岗位办公细则");
//            notice.setNoticeContent("样例");
//            notices.add(notice);
//        }
//
//        boolean b = noticeService.saveBatch(notices, 100);
        System.out.println("notices 保存是否成功："+true);

    }

    @Test
    public void testByDelete(){
//        Notice notice = new Notice();
//        notice.setMusername("zhangsan");

    }

    @Test
    public void testSave(){

    }



    @Test
    public void generatPassword(){
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }

}
