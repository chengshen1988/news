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
import com.news.hr.business.bean.po.LinkManage;
import com.news.hr.business.bean.query.LinkManageQuery;
import com.news.hr.business.bean.form.LinkManageForm;
import com.news.hr.business.bean.vo.LinkManageVo;
import com.news.hr.business.bean.convert.LinkManageConvert;
import com.news.hr.business.mapper.LinkManageMapper;
import com.news.hr.business.service.LinkManageService;
/**
 * <p>
 * 链接管理 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LinkManageServiceImpl extends ServiceImpl<LinkManageMapper, LinkManage> implements LinkManageService {

    @Resource
    private LinkManageMapper linkManageMapper;

    @Override
    public Integer save(LinkManageForm record) {
        LinkManage linkManage = LinkManageConvert.convertToPoByForm(record);
        return linkManageMapper.insert(linkManage);
    }

    @Override
    public Integer updateById(LinkManageForm record) {
        LinkManage linkManage = LinkManageConvert.convertToPoByForm(record);
        return linkManageMapper.updateById(linkManage);
    }

    @Override
    public Integer deleteById(String id) {
        return linkManageMapper.deleteById(id);
    }

    @Override
    public LinkManageVo selectById(String id) {
        LinkManage linkManage = linkManageMapper.selectById(id);
        LinkManageVo linkManageVo = LinkManageConvert.convertToVoByPo(linkManage);
        return linkManageVo;
    }

    @Override
    public IPage<LinkManageVo> selectPage(LinkManageQuery linkManageQuery){
        QueryWrapper<LinkManage> queryWrapper=new QueryWrapper<LinkManage>();
        Page<LinkManage> page = new Page<>(linkManageQuery.getPage(), linkManageQuery.getLimit());
        getQueryWrapper(queryWrapper, linkManageQuery);
        IPage<LinkManage> pageLinkManage = linkManageMapper.selectPage(page, queryWrapper);
        IPage<LinkManageVo> pageResult = new Page<>();
        pageResult.setRecords(LinkManageConvert.convertToVoByPo(pageLinkManage.getRecords()));
        pageResult.setCurrent(pageLinkManage.getCurrent());
        pageResult.setSize(pageLinkManage.getSize());
        pageResult.setTotal(pageLinkManage.getTotal());
        pageResult.setPages(pageLinkManage.getPages());
        return pageResult;
    }

    @Override
    public List<LinkManageVo> selectList(LinkManageQuery linkManageQuery){
        QueryWrapper<LinkManage> queryWrapper=new QueryWrapper<LinkManage>();
        getQueryWrapper(queryWrapper, linkManageQuery);
        List<LinkManage> list = linkManageMapper.selectList(queryWrapper);
        return LinkManageConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        LinkManage linkManage = linkManageMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<LinkManage> queryWrapper=new QueryWrapper<LinkManage>();
        queryWrapper.lambda().in(LinkManage::getLinkManageId, ids);
        List<LinkManage> linkManages = linkManageMapper.selectList(queryWrapper);
        //BeanUtils.set(linkManages, LinkManage::getLinkManageId, LinkManage::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<LinkManage> getQueryWrapper(QueryWrapper<LinkManage> queryWrapper,LinkManageQuery linkManageQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
