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
import com.news.hr.system.bean.po.AccessLog;
import com.news.hr.system.bean.query.AccessLogQuery;
import com.news.hr.system.bean.form.AccessLogForm;
import com.news.hr.system.bean.vo.AccessLogVo;
import com.news.hr.system.bean.convert.AccessLogConvert;
import com.news.hr.system.mapper.AccessLogMapper;
import com.news.hr.system.service.AccessLogService;
/**
 * <p>
 * 访问日志 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional
public class AccessLogServiceImpl extends ServiceImpl<AccessLogMapper, AccessLog> implements AccessLogService {

    @Resource
    private AccessLogMapper accessLogMapper;

    @Override
    public Integer save(AccessLogForm record) {
        AccessLog accessLog = AccessLogConvert.convertToPoByForm(record);
        return accessLogMapper.insert(accessLog);
    }

    @Override
    public Integer updateById(AccessLogForm record) {
        AccessLog accessLog = AccessLogConvert.convertToPoByForm(record);
        return accessLogMapper.updateById(accessLog);
    }

    @Override
    public Integer deleteById(String id) {
        return accessLogMapper.deleteById(id);
    }

    @Override
    public AccessLogVo selectById(String id) {
        AccessLog accessLog = accessLogMapper.selectById(id);
        AccessLogVo accessLogVo = AccessLogConvert.convertToVoByPo(accessLog);
        return accessLogVo;
    }

    @Override
    public IPage<AccessLogVo> selectPage(AccessLogQuery accessLogQuery){
        QueryWrapper<AccessLog> queryWrapper=new QueryWrapper<AccessLog>();
        Page<AccessLog> page = new Page<>(accessLogQuery.getPage(), accessLogQuery.getLimit());
        getQueryWrapper(queryWrapper, accessLogQuery);
        IPage<AccessLog> pageAccessLog = accessLogMapper.selectPage(page, queryWrapper);
        IPage<AccessLogVo> pageResult = new Page<>();
        pageResult.setRecords(AccessLogConvert.convertToVoByPo(pageAccessLog.getRecords()));
        pageResult.setCurrent(pageAccessLog.getCurrent());
        pageResult.setSize(pageAccessLog.getSize());
        pageResult.setTotal(pageAccessLog.getTotal());
        pageResult.setPages(pageAccessLog.getPages());
        return pageResult;
    }

    @Override
    public List<AccessLogVo> selectList(AccessLogQuery accessLogQuery){
        QueryWrapper<AccessLog> queryWrapper=new QueryWrapper<AccessLog>();
        getQueryWrapper(queryWrapper, accessLogQuery);
        List<AccessLog> list = accessLogMapper.selectList(queryWrapper);
        return AccessLogConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        AccessLog accessLog = accessLogMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<AccessLog> queryWrapper=new QueryWrapper<AccessLog>();
        queryWrapper.lambda().in(AccessLog::getAccessLogId, ids);
        List<AccessLog> accessLogs = accessLogMapper.selectList(queryWrapper);
        //BeanUtils.set(accessLogs, AccessLog::getAccessLogId, AccessLog::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<AccessLog> getQueryWrapper(QueryWrapper<AccessLog> queryWrapper,AccessLogQuery accessLogQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
