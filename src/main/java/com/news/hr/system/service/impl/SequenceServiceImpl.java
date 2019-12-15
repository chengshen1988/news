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
import com.news.hr.system.bean.po.Sequence;
import com.news.hr.system.bean.query.SequenceQuery;
import com.news.hr.system.bean.form.SequenceForm;
import com.news.hr.system.bean.vo.SequenceVo;
import com.news.hr.system.bean.convert.SequenceConvert;
import com.news.hr.system.mapper.SequenceMapper;
import com.news.hr.system.service.SequenceService;
/**
 * <p>
 * 序列表 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional
public class SequenceServiceImpl extends ServiceImpl<SequenceMapper, Sequence> implements SequenceService {

    @Resource
    private SequenceMapper sequenceMapper;

    @Override
    public Integer save(SequenceForm record) {
        Sequence sequence = SequenceConvert.convertToPoByForm(record);
        return sequenceMapper.insert(sequence);
    }

    @Override
    public Integer updateById(SequenceForm record) {
        Sequence sequence = SequenceConvert.convertToPoByForm(record);
        return sequenceMapper.updateById(sequence);
    }

    @Override
    public Integer deleteById(String id) {
        return sequenceMapper.deleteById(id);
    }

    @Override
    public SequenceVo selectById(String id) {
        Sequence sequence = sequenceMapper.selectById(id);
        SequenceVo sequenceVo = SequenceConvert.convertToVoByPo(sequence);
        return sequenceVo;
    }

    @Override
    public IPage<SequenceVo> selectPage(SequenceQuery sequenceQuery){
        QueryWrapper<Sequence> queryWrapper=new QueryWrapper<Sequence>();
        Page<Sequence> page = new Page<>(sequenceQuery.getPage(), sequenceQuery.getLimit());
        getQueryWrapper(queryWrapper, sequenceQuery);
        IPage<Sequence> pageSequence = sequenceMapper.selectPage(page, queryWrapper);
        IPage<SequenceVo> pageResult = new Page<>();
        pageResult.setRecords(SequenceConvert.convertToVoByPo(pageSequence.getRecords()));
        pageResult.setCurrent(pageSequence.getCurrent());
        pageResult.setSize(pageSequence.getSize());
        pageResult.setTotal(pageSequence.getTotal());
        pageResult.setPages(pageSequence.getPages());
        return pageResult;
    }

    @Override
    public List<SequenceVo> selectList(SequenceQuery sequenceQuery){
        QueryWrapper<Sequence> queryWrapper=new QueryWrapper<Sequence>();
        getQueryWrapper(queryWrapper, sequenceQuery);
        List<Sequence> list = sequenceMapper.selectList(queryWrapper);
        return SequenceConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Sequence sequence = sequenceMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Sequence> queryWrapper=new QueryWrapper<Sequence>();
        queryWrapper.lambda().in(Sequence::getSequenceId, ids);
        List<Sequence> sequences = sequenceMapper.selectList(queryWrapper);
        //BeanUtils.set(sequences, Sequence::getSequenceId, Sequence::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Sequence> getQueryWrapper(QueryWrapper<Sequence> queryWrapper,SequenceQuery sequenceQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
