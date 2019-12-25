package com.news.hr.business.service;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.news.hr.business.bean.po.NewsRecommend;
import com.news.hr.business.bean.query.NewsRecommendQuery;
import com.news.hr.business.bean.form.NewsRecommendForm;
import com.news.hr.business.bean.vo.NewsRecommendVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
public interface NewsRecommendService extends IService<NewsRecommend> {
    /**
    * 保存信息对象
    * @param record 信息对象
    * @return 影响记录数
    */
    Integer save(NewsRecommendForm record);

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
    Integer updateById(NewsRecommendForm record);

    /**
    * 根据主键查询信息对象
    * @param id 主键
    * @return 信息对象
    */
    NewsRecommendVo selectById(String id);

    /**
    *  分页查询
    * @param newsRecommendQuery
    * @return
    */
    IPage<NewsRecommendVo> selectPage(NewsRecommendQuery newsRecommendQuery);

    /**
     * 查询列表
     * @param newsRecommendQuery
     * @return
     */
    List<NewsRecommendVo> selectList(NewsRecommendQuery newsRecommendQuery);

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
    * @param newsRecommendQuery 前台传值的query对象
    */
    QueryWrapper<NewsRecommend> getQueryWrapper(QueryWrapper<NewsRecommend> queryWrapper,NewsRecommendQuery newsRecommendQuery);

    /*******************通用方法结束**********************/
}

