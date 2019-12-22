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
import com.news.hr.system.bean.po.LogInfo;
import com.news.hr.system.bean.query.LogInfoQuery;
import com.news.hr.system.bean.form.LogInfoForm;
import com.news.hr.system.bean.vo.LogInfoVo;
import com.news.hr.system.bean.convert.LogInfoConvert;
import com.news.hr.system.mapper.LogInfoMapper;
import com.news.hr.system.service.LogInfoService;
/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LogInfoServiceImpl extends ServiceImpl<LogInfoMapper, LogInfo> implements LogInfoService {

    @Resource
    private LogInfoMapper logInfoMapper;

    @Override
    public Integer save(LogInfoForm record) {
        LogInfo logInfo = LogInfoConvert.convertToPoByForm(record);
        return logInfoMapper.insert(logInfo);
    }

    @Override
    public Integer updateById(LogInfoForm record) {
        LogInfo logInfo = LogInfoConvert.convertToPoByForm(record);
        return logInfoMapper.updateById(logInfo);
    }

    @Override
    public Integer deleteById(String id) {
        return logInfoMapper.deleteById(id);
    }

    @Override
    public LogInfoVo selectById(String id) {
        LogInfo logInfo = logInfoMapper.selectById(id);
        LogInfoVo logInfoVo = LogInfoConvert.convertToVoByPo(logInfo);
        return logInfoVo;
    }

    @Override
    public IPage<LogInfoVo> selectPage(LogInfoQuery logInfoQuery){
        QueryWrapper<LogInfo> queryWrapper=new QueryWrapper<LogInfo>();
        Page<LogInfo> page = new Page<>(logInfoQuery.getPage(), logInfoQuery.getLimit());
        getQueryWrapper(queryWrapper, logInfoQuery);
        IPage<LogInfo> pageLogInfo = logInfoMapper.selectPage(page, queryWrapper);
        IPage<LogInfoVo> pageResult = new Page<>();
        pageResult.setRecords(LogInfoConvert.convertToVoByPo(pageLogInfo.getRecords()));
        pageResult.setCurrent(pageLogInfo.getCurrent());
        pageResult.setSize(pageLogInfo.getSize());
        pageResult.setTotal(pageLogInfo.getTotal());
        pageResult.setPages(pageLogInfo.getPages());
        return pageResult;
    }

    @Override
    public List<LogInfoVo> selectList(LogInfoQuery logInfoQuery){
        QueryWrapper<LogInfo> queryWrapper=new QueryWrapper<LogInfo>();
        getQueryWrapper(queryWrapper, logInfoQuery);
        List<LogInfo> list = logInfoMapper.selectList(queryWrapper);
        return LogInfoConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        LogInfo logInfo = logInfoMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<LogInfo> queryWrapper=new QueryWrapper<LogInfo>();
        queryWrapper.lambda().in(LogInfo::getLogInfoId, ids);
        List<LogInfo> logInfos = logInfoMapper.selectList(queryWrapper);
        //BeanUtils.set(logInfos, LogInfo::getLogInfoId, LogInfo::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<LogInfo> getQueryWrapper(QueryWrapper<LogInfo> queryWrapper,LogInfoQuery logInfoQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
