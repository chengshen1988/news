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
import com.news.hr.business.bean.po.NewsInfo;
import com.news.hr.business.bean.query.NewsInfoQuery;
import com.news.hr.business.bean.form.NewsInfoForm;
import com.news.hr.business.bean.vo.NewsInfoVo;
import com.news.hr.business.bean.convert.NewsInfoConvert;
import com.news.hr.business.mapper.NewsInfoMapper;
import com.news.hr.business.service.NewsInfoService;
/**
 * <p>
 * 新闻内容管理 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NewsInfoServiceImpl extends ServiceImpl<NewsInfoMapper, NewsInfo> implements NewsInfoService {

    @Resource
    private NewsInfoMapper newsInfoMapper;

    @Override
    public Integer save(NewsInfoForm record) {
        NewsInfo newsInfo = NewsInfoConvert.convertToPoByForm(record);
        return newsInfoMapper.insert(newsInfo);
    }

    @Override
    public Integer updateById(NewsInfoForm record) {
        NewsInfo newsInfo = NewsInfoConvert.convertToPoByForm(record);
        return newsInfoMapper.updateById(newsInfo);
    }

    @Override
    public Integer deleteById(String id) {
        return newsInfoMapper.deleteById(id);
    }

    @Override
    public NewsInfoVo selectById(String id) {
        NewsInfo newsInfo = newsInfoMapper.selectById(id);
        NewsInfoVo newsInfoVo = NewsInfoConvert.convertToVoByPo(newsInfo);
        return newsInfoVo;
    }

    @Override
    public IPage<NewsInfoVo> selectPage(NewsInfoQuery newsInfoQuery){
        QueryWrapper<NewsInfo> queryWrapper=new QueryWrapper<NewsInfo>();
        Page<NewsInfo> page = new Page<>(newsInfoQuery.getPage(), newsInfoQuery.getLimit());
        getQueryWrapper(queryWrapper, newsInfoQuery);
        IPage<NewsInfo> pageNewsInfo = newsInfoMapper.selectPage(page, queryWrapper);
        IPage<NewsInfoVo> pageResult = new Page<>();
        pageResult.setRecords(NewsInfoConvert.convertToVoByPo(pageNewsInfo.getRecords()));
        pageResult.setCurrent(pageNewsInfo.getCurrent());
        pageResult.setSize(pageNewsInfo.getSize());
        pageResult.setTotal(pageNewsInfo.getTotal());
        pageResult.setPages(pageNewsInfo.getPages());
        return pageResult;
    }

    @Override
    public List<NewsInfoVo> selectList(NewsInfoQuery newsInfoQuery){
        QueryWrapper<NewsInfo> queryWrapper=new QueryWrapper<NewsInfo>();
        getQueryWrapper(queryWrapper, newsInfoQuery);
        List<NewsInfo> list = newsInfoMapper.selectList(queryWrapper);
        return NewsInfoConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        NewsInfo newsInfo = newsInfoMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<NewsInfo> queryWrapper=new QueryWrapper<NewsInfo>();
        queryWrapper.lambda().in(NewsInfo::getNewsInfoId, ids);
        List<NewsInfo> newsInfos = newsInfoMapper.selectList(queryWrapper);
        //BeanUtils.set(newsInfos, NewsInfo::getNewsInfoId, NewsInfo::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<NewsInfo> getQueryWrapper(QueryWrapper<NewsInfo> queryWrapper,NewsInfoQuery newsInfoQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
