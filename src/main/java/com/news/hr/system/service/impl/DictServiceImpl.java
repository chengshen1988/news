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
import com.news.hr.system.bean.po.Dict;
import com.news.hr.system.bean.query.DictQuery;
import com.news.hr.system.bean.form.DictForm;
import com.news.hr.system.bean.vo.DictVo;
import com.news.hr.system.bean.convert.DictConvert;
import com.news.hr.system.mapper.DictMapper;
import com.news.hr.system.service.DictService;
/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Resource
    private DictMapper dictMapper;

    @Override
    public Integer save(DictForm record) {
        Dict dict = DictConvert.convertToPoByForm(record);
        return dictMapper.insert(dict);
    }

    @Override
    public Integer updateById(DictForm record) {
        Dict dict = DictConvert.convertToPoByForm(record);
        return dictMapper.updateById(dict);
    }

    @Override
    public Integer deleteById(String id) {
        return dictMapper.deleteById(id);
    }

    @Override
    public DictVo selectById(String id) {
        Dict dict = dictMapper.selectById(id);
        DictVo dictVo = DictConvert.convertToVoByPo(dict);
        return dictVo;
    }

    @Override
    public IPage<DictVo> selectPage(DictQuery dictQuery){
        QueryWrapper<Dict> queryWrapper=new QueryWrapper<Dict>();
        Page<Dict> page = new Page<>(dictQuery.getPage(), dictQuery.getLimit());
        getQueryWrapper(queryWrapper, dictQuery);
        IPage<Dict> pageDict = dictMapper.selectPage(page, queryWrapper);
        IPage<DictVo> pageResult = new Page<>();
        pageResult.setRecords(DictConvert.convertToVoByPo(pageDict.getRecords()));
        pageResult.setCurrent(pageDict.getCurrent());
        pageResult.setSize(pageDict.getSize());
        pageResult.setTotal(pageDict.getTotal());
        pageResult.setPages(pageDict.getPages());
        return pageResult;
    }

    @Override
    public List<DictVo> selectList(DictQuery dictQuery){
        QueryWrapper<Dict> queryWrapper=new QueryWrapper<Dict>();
        getQueryWrapper(queryWrapper, dictQuery);
        List<Dict> list = dictMapper.selectList(queryWrapper);
        return DictConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Dict dict = dictMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Dict> queryWrapper=new QueryWrapper<Dict>();
        queryWrapper.lambda().in(Dict::getDictId, ids);
        List<Dict> dicts = dictMapper.selectList(queryWrapper);
        //BeanUtils.set(dicts, Dict::getDictId, Dict::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Dict> getQueryWrapper(QueryWrapper<Dict> queryWrapper,DictQuery dictQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
