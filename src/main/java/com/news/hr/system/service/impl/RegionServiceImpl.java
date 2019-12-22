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
import com.news.hr.system.bean.po.Region;
import com.news.hr.system.bean.query.RegionQuery;
import com.news.hr.system.bean.form.RegionForm;
import com.news.hr.system.bean.vo.RegionVo;
import com.news.hr.system.bean.convert.RegionConvert;
import com.news.hr.system.mapper.RegionMapper;
import com.news.hr.system.service.RegionService;
/**
 * <p>
 * 中国地区 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {

    @Resource
    private RegionMapper regionMapper;

    @Override
    public Integer save(RegionForm record) {
        Region region = RegionConvert.convertToPoByForm(record);
        return regionMapper.insert(region);
    }

    @Override
    public Integer updateById(RegionForm record) {
        Region region = RegionConvert.convertToPoByForm(record);
        return regionMapper.updateById(region);
    }

    @Override
    public Integer deleteById(String id) {
        return regionMapper.deleteById(id);
    }

    @Override
    public RegionVo selectById(String id) {
        Region region = regionMapper.selectById(id);
        RegionVo regionVo = RegionConvert.convertToVoByPo(region);
        return regionVo;
    }

    @Override
    public IPage<RegionVo> selectPage(RegionQuery regionQuery){
        QueryWrapper<Region> queryWrapper=new QueryWrapper<Region>();
        Page<Region> page = new Page<>(regionQuery.getPage(), regionQuery.getLimit());
        getQueryWrapper(queryWrapper, regionQuery);
        IPage<Region> pageRegion = regionMapper.selectPage(page, queryWrapper);
        IPage<RegionVo> pageResult = new Page<>();
        pageResult.setRecords(RegionConvert.convertToVoByPo(pageRegion.getRecords()));
        pageResult.setCurrent(pageRegion.getCurrent());
        pageResult.setSize(pageRegion.getSize());
        pageResult.setTotal(pageRegion.getTotal());
        pageResult.setPages(pageRegion.getPages());
        return pageResult;
    }

    @Override
    public List<RegionVo> selectList(RegionQuery regionQuery){
        QueryWrapper<Region> queryWrapper=new QueryWrapper<Region>();
        getQueryWrapper(queryWrapper, regionQuery);
        List<Region> list = regionMapper.selectList(queryWrapper);
        return RegionConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Region region = regionMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Region> queryWrapper=new QueryWrapper<Region>();
        queryWrapper.lambda().in(Region::getRegionId, ids);
        List<Region> regions = regionMapper.selectList(queryWrapper);
        //BeanUtils.set(regions, Region::getRegionId, Region::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Region> getQueryWrapper(QueryWrapper<Region> queryWrapper,RegionQuery regionQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
