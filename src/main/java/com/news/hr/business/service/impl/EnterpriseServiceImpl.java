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
import com.news.hr.business.bean.po.Enterprise;
import com.news.hr.business.bean.query.EnterpriseQuery;
import com.news.hr.business.bean.form.EnterpriseForm;
import com.news.hr.business.bean.vo.EnterpriseVo;
import com.news.hr.business.bean.convert.EnterpriseConvert;
import com.news.hr.business.mapper.EnterpriseMapper;
import com.news.hr.business.service.EnterpriseService;
/**
 * <p>
 * 企业信息 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise> implements EnterpriseService {

    @Resource
    private EnterpriseMapper enterpriseMapper;

    @Override
    public Integer save(EnterpriseForm record) {
        Enterprise enterprise = EnterpriseConvert.convertToPoByForm(record);
        return enterpriseMapper.insert(enterprise);
    }

    @Override
    public Integer updateById(EnterpriseForm record) {
        Enterprise enterprise = EnterpriseConvert.convertToPoByForm(record);
        return enterpriseMapper.updateById(enterprise);
    }

    @Override
    public Integer deleteById(String id) {
        return enterpriseMapper.deleteById(id);
    }

    @Override
    public EnterpriseVo selectById(String id) {
        Enterprise enterprise = enterpriseMapper.selectById(id);
        EnterpriseVo enterpriseVo = EnterpriseConvert.convertToVoByPo(enterprise);
        return enterpriseVo;
    }

    @Override
    public IPage<EnterpriseVo> selectPage(EnterpriseQuery enterpriseQuery){
        QueryWrapper<Enterprise> queryWrapper=new QueryWrapper<Enterprise>();
        Page<Enterprise> page = new Page<>(enterpriseQuery.getPage(), enterpriseQuery.getLimit());
        getQueryWrapper(queryWrapper, enterpriseQuery);
        IPage<Enterprise> pageEnterprise = enterpriseMapper.selectPage(page, queryWrapper);
        IPage<EnterpriseVo> pageResult = new Page<>();
        pageResult.setRecords(EnterpriseConvert.convertToVoByPo(pageEnterprise.getRecords()));
        pageResult.setCurrent(pageEnterprise.getCurrent());
        pageResult.setSize(pageEnterprise.getSize());
        pageResult.setTotal(pageEnterprise.getTotal());
        pageResult.setPages(pageEnterprise.getPages());
        return pageResult;
    }

    @Override
    public List<EnterpriseVo> selectList(EnterpriseQuery enterpriseQuery){
        QueryWrapper<Enterprise> queryWrapper=new QueryWrapper<Enterprise>();
        getQueryWrapper(queryWrapper, enterpriseQuery);
        List<Enterprise> list = enterpriseMapper.selectList(queryWrapper);
        return EnterpriseConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Enterprise enterprise = enterpriseMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Enterprise> queryWrapper=new QueryWrapper<Enterprise>();
        queryWrapper.lambda().in(Enterprise::getEnterpriseId, ids);
        List<Enterprise> enterprises = enterpriseMapper.selectList(queryWrapper);
        //BeanUtils.set(enterprises, Enterprise::getEnterpriseId, Enterprise::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Enterprise> getQueryWrapper(QueryWrapper<Enterprise> queryWrapper,EnterpriseQuery enterpriseQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
