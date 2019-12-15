package com.news.hr.framework.config.database;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.news.hr.framework.constant.DefaultField;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 填充器
 *
 * @author nieqiurong 2018-08-10 22:59:23.
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ....");
        //避免使用metaObject.setValue()
        this.setFieldValByName(DefaultField.cUserId, "zhangsan", metaObject);
        this.setFieldValByName(DefaultField.cUserName, "张三", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.info("start update fill ....");
        this.setFieldValByName(DefaultField.mUserId, "zhangsan", metaObject);
        this.setFieldValByName(DefaultField.mUserName, "张三", metaObject);
    }
}
