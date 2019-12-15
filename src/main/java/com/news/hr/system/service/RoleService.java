package com.news.hr.system.service;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.news.hr.system.bean.po.Role;
import com.news.hr.system.bean.query.RoleQuery;
import com.news.hr.system.bean.form.RoleForm;
import com.news.hr.system.bean.vo.RoleVo;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
public interface RoleService extends IService<Role> {
    /**
    * 保存信息对象
    * @param record 信息对象
    * @return 影响记录数
    */
    Integer save(RoleForm record);

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
    Integer updateById(RoleForm record);

    /**
    * 根据主键查询信息对象
    * @param id 主键
    * @return 信息对象
    */
    RoleVo selectById(String id);

    /**
    *  分页查询
    * @param roleQuery
    * @return
    */
    IPage<RoleVo> selectPage(RoleQuery roleQuery);

    /**
     * 查询列表
     * @param roleQuery
     * @return
     */
    List<RoleVo> selectList(RoleQuery roleQuery);

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
    * @param roleQuery 前台传值的query对象
    */
    QueryWrapper<Role> getQueryWrapper(QueryWrapper<Role> queryWrapper,RoleQuery roleQuery);

    /*******************通用方法结束**********************/
}

