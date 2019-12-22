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
import com.news.hr.system.bean.po.LogException;
import com.news.hr.system.bean.query.LogExceptionQuery;
import com.news.hr.system.bean.form.LogExceptionForm;
import com.news.hr.system.bean.vo.LogExceptionVo;
import com.news.hr.system.bean.convert.LogExceptionConvert;
import com.news.hr.system.mapper.LogExceptionMapper;
import com.news.hr.system.service.LogExceptionService;
/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LogExceptionServiceImpl extends ServiceImpl<LogExceptionMapper, LogException> implements LogExceptionService {

    @Resource
    private LogExceptionMapper logExceptionMapper;

    @Override
    public Integer save(LogExceptionForm record) {
        LogException logException = LogExceptionConvert.convertToPoByForm(record);
        return logExceptionMapper.insert(logException);
    }

    @Override
    public Integer updateById(LogExceptionForm record) {
        LogException logException = LogExceptionConvert.convertToPoByForm(record);
        return logExceptionMapper.updateById(logException);
    }

    @Override
    public Integer deleteById(String id) {
        return logExceptionMapper.deleteById(id);
    }

    @Override
    public LogExceptionVo selectById(String id) {
        LogException logException = logExceptionMapper.selectById(id);
        LogExceptionVo logExceptionVo = LogExceptionConvert.convertToVoByPo(logException);
        return logExceptionVo;
    }

    @Override
    public IPage<LogExceptionVo> selectPage(LogExceptionQuery logExceptionQuery){
        QueryWrapper<LogException> queryWrapper=new QueryWrapper<LogException>();
        Page<LogException> page = new Page<>(logExceptionQuery.getPage(), logExceptionQuery.getLimit());
        getQueryWrapper(queryWrapper, logExceptionQuery);
        IPage<LogException> pageLogException = logExceptionMapper.selectPage(page, queryWrapper);
        IPage<LogExceptionVo> pageResult = new Page<>();
        pageResult.setRecords(LogExceptionConvert.convertToVoByPo(pageLogException.getRecords()));
        pageResult.setCurrent(pageLogException.getCurrent());
        pageResult.setSize(pageLogException.getSize());
        pageResult.setTotal(pageLogException.getTotal());
        pageResult.setPages(pageLogException.getPages());
        return pageResult;
    }

    @Override
    public List<LogExceptionVo> selectList(LogExceptionQuery logExceptionQuery){
        QueryWrapper<LogException> queryWrapper=new QueryWrapper<LogException>();
        getQueryWrapper(queryWrapper, logExceptionQuery);
        List<LogException> list = logExceptionMapper.selectList(queryWrapper);
        return LogExceptionConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        LogException logException = logExceptionMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<LogException> queryWrapper=new QueryWrapper<LogException>();
        queryWrapper.lambda().in(LogException::getLogExceptionId, ids);
        List<LogException> logExceptions = logExceptionMapper.selectList(queryWrapper);
        //BeanUtils.set(logExceptions, LogException::getLogExceptionId, LogException::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<LogException> getQueryWrapper(QueryWrapper<LogException> queryWrapper,LogExceptionQuery logExceptionQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
