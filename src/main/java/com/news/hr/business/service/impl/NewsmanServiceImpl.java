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
import com.news.hr.business.bean.po.Newsman;
import com.news.hr.business.bean.query.NewsmanQuery;
import com.news.hr.business.bean.form.NewsmanForm;
import com.news.hr.business.bean.vo.NewsmanVo;
import com.news.hr.business.bean.convert.NewsmanConvert;
import com.news.hr.business.mapper.NewsmanMapper;
import com.news.hr.business.service.NewsmanService;
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
public class NewsmanServiceImpl extends ServiceImpl<NewsmanMapper, Newsman> implements NewsmanService {

    @Resource
    private NewsmanMapper newsmanMapper;

    @Override
    public Integer save(NewsmanForm record) {
        Newsman newsman = NewsmanConvert.convertToPoByForm(record);
        return newsmanMapper.insert(newsman);
    }

    @Override
    public Integer updateById(NewsmanForm record) {
        Newsman newsman = NewsmanConvert.convertToPoByForm(record);
        return newsmanMapper.updateById(newsman);
    }

    @Override
    public Integer deleteById(String id) {
        return newsmanMapper.deleteById(id);
    }

    @Override
    public NewsmanVo selectById(String id) {
        Newsman newsman = newsmanMapper.selectById(id);
        NewsmanVo newsmanVo = NewsmanConvert.convertToVoByPo(newsman);
        return newsmanVo;
    }

    @Override
    public IPage<NewsmanVo> selectPage(NewsmanQuery newsmanQuery){
        QueryWrapper<Newsman> queryWrapper=new QueryWrapper<Newsman>();
        Page<Newsman> page = new Page<>(newsmanQuery.getPage(), newsmanQuery.getLimit());
        getQueryWrapper(queryWrapper, newsmanQuery);
        IPage<Newsman> pageNewsman = newsmanMapper.selectPage(page, queryWrapper);
        IPage<NewsmanVo> pageResult = new Page<>();
        pageResult.setRecords(NewsmanConvert.convertToVoByPo(pageNewsman.getRecords()));
        pageResult.setCurrent(pageNewsman.getCurrent());
        pageResult.setSize(pageNewsman.getSize());
        pageResult.setTotal(pageNewsman.getTotal());
        pageResult.setPages(pageNewsman.getPages());
        return pageResult;
    }

    @Override
    public List<NewsmanVo> selectList(NewsmanQuery newsmanQuery){
        QueryWrapper<Newsman> queryWrapper=new QueryWrapper<Newsman>();
        getQueryWrapper(queryWrapper, newsmanQuery);
        List<Newsman> list = newsmanMapper.selectList(queryWrapper);
        return NewsmanConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Newsman newsman = newsmanMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Newsman> queryWrapper=new QueryWrapper<Newsman>();
        queryWrapper.lambda().in(Newsman::getNewsmanId, ids);
        List<Newsman> newsmans = newsmanMapper.selectList(queryWrapper);
        //BeanUtils.set(newsmans, Newsman::getNewsmanId, Newsman::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Newsman> getQueryWrapper(QueryWrapper<Newsman> queryWrapper,NewsmanQuery newsmanQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
