package com.news.hr.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.news.hr.framework.config.security.entity.UserSession;
import com.news.hr.system.bean.form.UserForm;
import com.news.hr.system.bean.po.User;
import com.news.hr.system.bean.query.UserQuery;
import com.news.hr.system.bean.vo.UserVo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
public interface UserService extends IService<User> {
    /**
    * 保存信息对象
    * @param record 信息对象
    * @return 影响记录数
    */
    Integer save(UserForm record);

    /**
    * 根据主键删除信息对象
    * 逻辑删除,字段改为删除态
    * @param id 主键
    * @return 影响记录数
    */
    Integer deleteById(String id);

    /**
    * 根据主键更新信息对象
    * @param record 信息对象
    * @return 影响记录数
    */
    Integer updateById(UserForm record);

    /**
    * 根据主键查询信息对象
    * @param id 主键
    * @return 信息对象
    */
    UserVo selectById(String id);

    /**
    *  分页查询
    * @param userQuery
    * @return
    */
    IPage<UserVo> selectPage(UserQuery userQuery);

    /**
     * 查询列表
     * @param userQuery
     * @return
     */
    List<UserVo> selectList(UserQuery userQuery);

    /**
     * 根据角色id赋值名称
     * @param t 实体对象
     * @param f id的get方法
     * @param c name的set方法
     * @param <T>
     */
    <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c);

    /**
    * 根据角色id赋值名称
    * @param l 实体对象集合
    * @param f id的get方法
    * @param c name的set方法
    * @param <T>
    */
    <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c);

    /**
    * 生成查询条件
    * @param queryWrapper 生成的条件
    * @param userQuery 前台传值的query对象
    */
    QueryWrapper<User> getQueryWrapper(QueryWrapper<User> queryWrapper,UserQuery userQuery);

    /*******************通用方法结束**********************/

    /**
     * 获取用户
     * @author Chen Seen
     * @param userQuery :
     * @return com.news.hr.framework.config.security.entity.UserSession
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @date 2019/12/15 4:22
     */
    UserSession getUserSession(UserQuery userQuery);

}

