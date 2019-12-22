package com.news.hr.system.service.impl;

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
import com.news.hr.system.bean.po.Org;
import com.news.hr.system.bean.query.OrgQuery;
import com.news.hr.system.bean.form.OrgForm;
import com.news.hr.system.bean.vo.OrgVo;
import com.news.hr.system.bean.convert.OrgConvert;
import com.news.hr.system.mapper.OrgMapper;
import com.news.hr.system.service.OrgService;
/**
 * <p>
 * 机构 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements OrgService {

    @Resource
    private OrgMapper orgMapper;

    @Override
    public Integer save(OrgForm record) {
        Org org = OrgConvert.convertToPoByForm(record);
        return orgMapper.insert(org);
    }

    @Override
    public Integer updateById(OrgForm record) {
        Org org = OrgConvert.convertToPoByForm(record);
        return orgMapper.updateById(org);
    }

    @Override
    public Integer deleteById(String id) {
        return orgMapper.deleteById(id);
    }

    @Override
    public OrgVo selectById(String id) {
        Org org = orgMapper.selectById(id);
        OrgVo orgVo = OrgConvert.convertToVoByPo(org);
        return orgVo;
    }

    @Override
    public IPage<OrgVo> selectPage(OrgQuery orgQuery){
        QueryWrapper<Org> queryWrapper=new QueryWrapper<Org>();
        Page<Org> page = new Page<>(orgQuery.getPage(), orgQuery.getLimit());
        getQueryWrapper(queryWrapper, orgQuery);
        IPage<Org> pageOrg = orgMapper.selectPage(page, queryWrapper);
        IPage<OrgVo> pageResult = new Page<>();
        pageResult.setRecords(OrgConvert.convertToVoByPo(pageOrg.getRecords()));
        pageResult.setCurrent(pageOrg.getCurrent());
        pageResult.setSize(pageOrg.getSize());
        pageResult.setTotal(pageOrg.getTotal());
        pageResult.setPages(pageOrg.getPages());
        return pageResult;
    }

    @Override
    public List<OrgVo> selectList(OrgQuery orgQuery){
        QueryWrapper<Org> queryWrapper=new QueryWrapper<Org>();
        getQueryWrapper(queryWrapper, orgQuery);
        List<Org> list = orgMapper.selectList(queryWrapper);
        return OrgConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Org org = orgMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Org> queryWrapper=new QueryWrapper<Org>();
        queryWrapper.lambda().in(Org::getOrgId, ids);
        List<Org> orgs = orgMapper.selectList(queryWrapper);
        //BeanUtils.set(orgs, Org::getOrgId, Org::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Org> getQueryWrapper(QueryWrapper<Org> queryWrapper,OrgQuery orgQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
