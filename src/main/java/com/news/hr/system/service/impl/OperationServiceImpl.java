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
import com.news.hr.system.bean.po.Operation;
import com.news.hr.system.bean.query.OperationQuery;
import com.news.hr.system.bean.form.OperationForm;
import com.news.hr.system.bean.vo.OperationVo;
import com.news.hr.system.bean.convert.OperationConvert;
import com.news.hr.system.mapper.OperationMapper;
import com.news.hr.system.service.OperationService;
/**
 * <p>
 * 系统操作 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional
public class OperationServiceImpl extends ServiceImpl<OperationMapper, Operation> implements OperationService {

    @Resource
    private OperationMapper operationMapper;

    @Override
    public Integer save(OperationForm record) {
        Operation operation = OperationConvert.convertToPoByForm(record);
        return operationMapper.insert(operation);
    }

    @Override
    public Integer updateById(OperationForm record) {
        Operation operation = OperationConvert.convertToPoByForm(record);
        return operationMapper.updateById(operation);
    }

    @Override
    public Integer deleteById(String id) {
        return operationMapper.deleteById(id);
    }

    @Override
    public OperationVo selectById(String id) {
        Operation operation = operationMapper.selectById(id);
        OperationVo operationVo = OperationConvert.convertToVoByPo(operation);
        return operationVo;
    }

    @Override
    public IPage<OperationVo> selectPage(OperationQuery operationQuery){
        QueryWrapper<Operation> queryWrapper=new QueryWrapper<Operation>();
        Page<Operation> page = new Page<>(operationQuery.getPage(), operationQuery.getLimit());
        getQueryWrapper(queryWrapper, operationQuery);
        IPage<Operation> pageOperation = operationMapper.selectPage(page, queryWrapper);
        IPage<OperationVo> pageResult = new Page<>();
        pageResult.setRecords(OperationConvert.convertToVoByPo(pageOperation.getRecords()));
        pageResult.setCurrent(pageOperation.getCurrent());
        pageResult.setSize(pageOperation.getSize());
        pageResult.setTotal(pageOperation.getTotal());
        pageResult.setPages(pageOperation.getPages());
        return pageResult;
    }

    @Override
    public List<OperationVo> selectList(OperationQuery operationQuery){
        QueryWrapper<Operation> queryWrapper=new QueryWrapper<Operation>();
        getQueryWrapper(queryWrapper, operationQuery);
        List<Operation> list = operationMapper.selectList(queryWrapper);
        return OperationConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Operation operation = operationMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Operation> queryWrapper=new QueryWrapper<Operation>();
        queryWrapper.lambda().in(Operation::getOperationId, ids);
        List<Operation> operations = operationMapper.selectList(queryWrapper);
        //BeanUtils.set(operations, Operation::getOperationId, Operation::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Operation> getQueryWrapper(QueryWrapper<Operation> queryWrapper,OperationQuery operationQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
