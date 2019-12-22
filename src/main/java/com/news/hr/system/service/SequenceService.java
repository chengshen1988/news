package com.news.hr.system.service;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.news.hr.system.bean.po.Sequence;
import com.news.hr.system.bean.query.SequenceQuery;
import com.news.hr.system.bean.form.SequenceForm;
import com.news.hr.system.bean.vo.SequenceVo;

/**
 * <p>
 * 序列表 服务类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
public interface SequenceService extends IService<Sequence> {
    /**
    * 保存信息对象
    * @param record 信息对象
    * @return 影响记录数
    */
    Integer save(SequenceForm record);

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
    Integer updateById(SequenceForm record);

    /**
    * 根据主键查询信息对象
    * @param id 主键
    * @return 信息对象
    */
    SequenceVo selectById(String id);

    /**
    *  分页查询
    * @param sequenceQuery
    * @return
    */
    IPage<SequenceVo> selectPage(SequenceQuery sequenceQuery);

    /**
     * 查询列表
     * @param sequenceQuery
     * @return
     */
    List<SequenceVo> selectList(SequenceQuery sequenceQuery);

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
    * @param sequenceQuery 前台传值的query对象
    */
    QueryWrapper<Sequence> getQueryWrapper(QueryWrapper<Sequence> queryWrapper,SequenceQuery sequenceQuery);

    /*******************通用方法结束**********************/
}

