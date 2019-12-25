package com.news.hr.business.service.impl;

import java.util.List;
import javax.annotation.Resource;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.news.hr.framework.utils.BeanUtils;
import com.news.hr.business.bean.po.NewsRecommend;
import com.news.hr.business.bean.query.NewsRecommendQuery;
import com.news.hr.business.bean.form.NewsRecommendForm;
import com.news.hr.business.bean.vo.NewsRecommendVo;
import com.news.hr.business.bean.convert.NewsRecommendConvert;
import com.news.hr.business.mapper.NewsRecommendMapper;
import com.news.hr.business.service.NewsRecommendService;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NewsRecommendServiceImpl extends ServiceImpl<NewsRecommendMapper, NewsRecommend> implements NewsRecommendService {

    @Resource
    private NewsRecommendMapper newsRecommendMapper;

    @Override
    public Integer save(NewsRecommendForm record) {
        NewsRecommend newsRecommend = NewsRecommendConvert.convertToPoByForm(record);
        return newsRecommendMapper.insert(newsRecommend);
    }

    @Override
    public Integer updateById(NewsRecommendForm record) {
        NewsRecommend newsRecommend = NewsRecommendConvert.convertToPoByForm(record);
        return newsRecommendMapper.updateById(newsRecommend);
    }

    @Override
    public Integer deleteById(String id) {
        return newsRecommendMapper.deleteById(id);
    }

    @Override
    public NewsRecommendVo selectById(String id) {
        NewsRecommend newsRecommend = newsRecommendMapper.selectById(id);
        NewsRecommendVo newsRecommendVo = NewsRecommendConvert.convertToVoByPo(newsRecommend);
        return newsRecommendVo;
    }

    @Override
    public IPage<NewsRecommendVo> selectPage(NewsRecommendQuery newsRecommendQuery){
        QueryWrapper<NewsRecommend> queryWrapper=new QueryWrapper<NewsRecommend>();
        Page<NewsRecommend> page = new Page<>(newsRecommendQuery.getPage(), newsRecommendQuery.getLimit());
        getQueryWrapper(queryWrapper, newsRecommendQuery);
        IPage<NewsRecommend> pageNewsRecommend = newsRecommendMapper.selectPage(page, queryWrapper);
        IPage<NewsRecommendVo> pageResult = new Page<>();
        pageResult.setRecords(NewsRecommendConvert.convertToVoByPo(pageNewsRecommend.getRecords()));
        pageResult.setCurrent(pageNewsRecommend.getCurrent());
        pageResult.setSize(pageNewsRecommend.getSize());
        pageResult.setTotal(pageNewsRecommend.getTotal());
        pageResult.setPages(pageNewsRecommend.getPages());
        return pageResult;
    }

    @Override
    public List<NewsRecommendVo> selectList(NewsRecommendQuery newsRecommendQuery){
        QueryWrapper<NewsRecommend> queryWrapper=new QueryWrapper<NewsRecommend>();
        getQueryWrapper(queryWrapper, newsRecommendQuery);
        List<NewsRecommend> list = newsRecommendMapper.selectList(queryWrapper);
        return NewsRecommendConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        NewsRecommend newsRecommend = newsRecommendMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<NewsRecommend> queryWrapper=new QueryWrapper<NewsRecommend>();
        queryWrapper.lambda().in(NewsRecommend::getNewsRecommendId, ids);
        List<NewsRecommend> newsRecommends = newsRecommendMapper.selectList(queryWrapper);
        //BeanUtils.set(newsRecommends, NewsRecommend::getNewsRecommendId, NewsRecommend::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<NewsRecommend> getQueryWrapper(QueryWrapper<NewsRecommend> queryWrapper,NewsRecommendQuery newsRecommendQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
