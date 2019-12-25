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
import com.news.hr.business.bean.po.Content;
import com.news.hr.business.bean.query.ContentQuery;
import com.news.hr.business.bean.form.ContentForm;
import com.news.hr.business.bean.vo.ContentVo;
import com.news.hr.business.bean.convert.ContentConvert;
import com.news.hr.business.mapper.ContentMapper;
import com.news.hr.business.service.ContentService;
/**
 * <p>
 * 文档内容 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService {

    @Resource
    private ContentMapper contentMapper;

    @Override
    public Integer save(ContentForm record) {
        Content content = ContentConvert.convertToPoByForm(record);
        return contentMapper.insert(content);
    }

    @Override
    public Integer updateById(ContentForm record) {
        Content content = ContentConvert.convertToPoByForm(record);
        return contentMapper.updateById(content);
    }

    @Override
    public Integer deleteById(String id) {
        return contentMapper.deleteById(id);
    }

    @Override
    public ContentVo selectById(String id) {
        Content content = contentMapper.selectById(id);
        ContentVo contentVo = ContentConvert.convertToVoByPo(content);
        return contentVo;
    }

    @Override
    public IPage<ContentVo> selectPage(ContentQuery contentQuery){
        QueryWrapper<Content> queryWrapper=new QueryWrapper<Content>();
        Page<Content> page = new Page<>(contentQuery.getPage(), contentQuery.getLimit());
        getQueryWrapper(queryWrapper, contentQuery);
        IPage<Content> pageContent = contentMapper.selectPage(page, queryWrapper);
        IPage<ContentVo> pageResult = new Page<>();
        pageResult.setRecords(ContentConvert.convertToVoByPo(pageContent.getRecords()));
        pageResult.setCurrent(pageContent.getCurrent());
        pageResult.setSize(pageContent.getSize());
        pageResult.setTotal(pageContent.getTotal());
        pageResult.setPages(pageContent.getPages());
        return pageResult;
    }

    @Override
    public List<ContentVo> selectList(ContentQuery contentQuery){
        QueryWrapper<Content> queryWrapper=new QueryWrapper<Content>();
        getQueryWrapper(queryWrapper, contentQuery);
        List<Content> list = contentMapper.selectList(queryWrapper);
        return ContentConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Content content = contentMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Content> queryWrapper=new QueryWrapper<Content>();
        queryWrapper.lambda().in(Content::getContentId, ids);
        List<Content> contents = contentMapper.selectList(queryWrapper);
        //BeanUtils.set(contents, Content::getContentId, Content::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Content> getQueryWrapper(QueryWrapper<Content> queryWrapper,ContentQuery contentQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
