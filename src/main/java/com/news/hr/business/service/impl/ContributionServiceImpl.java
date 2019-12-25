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
import com.news.hr.business.bean.po.Contribution;
import com.news.hr.business.bean.query.ContributionQuery;
import com.news.hr.business.bean.form.ContributionForm;
import com.news.hr.business.bean.vo.ContributionVo;
import com.news.hr.business.bean.convert.ContributionConvert;
import com.news.hr.business.mapper.ContributionMapper;
import com.news.hr.business.service.ContributionService;
/**
 * <p>
 * 投稿管理 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ContributionServiceImpl extends ServiceImpl<ContributionMapper, Contribution> implements ContributionService {

    @Resource
    private ContributionMapper contributionMapper;

    @Override
    public Integer save(ContributionForm record) {
        Contribution contribution = ContributionConvert.convertToPoByForm(record);
        return contributionMapper.insert(contribution);
    }

    @Override
    public Integer updateById(ContributionForm record) {
        Contribution contribution = ContributionConvert.convertToPoByForm(record);
        return contributionMapper.updateById(contribution);
    }

    @Override
    public Integer deleteById(String id) {
        return contributionMapper.deleteById(id);
    }

    @Override
    public ContributionVo selectById(String id) {
        Contribution contribution = contributionMapper.selectById(id);
        ContributionVo contributionVo = ContributionConvert.convertToVoByPo(contribution);
        return contributionVo;
    }

    @Override
    public IPage<ContributionVo> selectPage(ContributionQuery contributionQuery){
        QueryWrapper<Contribution> queryWrapper=new QueryWrapper<Contribution>();
        Page<Contribution> page = new Page<>(contributionQuery.getPage(), contributionQuery.getLimit());
        getQueryWrapper(queryWrapper, contributionQuery);
        IPage<Contribution> pageContribution = contributionMapper.selectPage(page, queryWrapper);
        IPage<ContributionVo> pageResult = new Page<>();
        pageResult.setRecords(ContributionConvert.convertToVoByPo(pageContribution.getRecords()));
        pageResult.setCurrent(pageContribution.getCurrent());
        pageResult.setSize(pageContribution.getSize());
        pageResult.setTotal(pageContribution.getTotal());
        pageResult.setPages(pageContribution.getPages());
        return pageResult;
    }

    @Override
    public List<ContributionVo> selectList(ContributionQuery contributionQuery){
        QueryWrapper<Contribution> queryWrapper=new QueryWrapper<Contribution>();
        getQueryWrapper(queryWrapper, contributionQuery);
        List<Contribution> list = contributionMapper.selectList(queryWrapper);
        return ContributionConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Contribution contribution = contributionMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Contribution> queryWrapper=new QueryWrapper<Contribution>();
        queryWrapper.lambda().in(Contribution::getContributionId, ids);
        List<Contribution> contributions = contributionMapper.selectList(queryWrapper);
        //BeanUtils.set(contributions, Contribution::getContributionId, Contribution::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Contribution> getQueryWrapper(QueryWrapper<Contribution> queryWrapper,ContributionQuery contributionQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
