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
import com.news.hr.system.bean.po.Notice;
import com.news.hr.system.bean.query.NoticeQuery;
import com.news.hr.system.bean.form.NoticeForm;
import com.news.hr.system.bean.vo.NoticeVo;
import com.news.hr.system.bean.convert.NoticeConvert;
import com.news.hr.system.mapper.NoticeMapper;
import com.news.hr.system.service.NoticeService;
/**
 * <p>
 * 公告 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public Integer save(NoticeForm record) {
        Notice notice = NoticeConvert.convertToPoByForm(record);
        return noticeMapper.insert(notice);
    }

    @Override
    public Integer updateById(NoticeForm record) {
        Notice notice = NoticeConvert.convertToPoByForm(record);
        return noticeMapper.updateById(notice);
    }

    @Override
    public Integer deleteById(String id) {
        return noticeMapper.deleteById(id);
    }

    @Override
    public NoticeVo selectById(String id) {
        Notice notice = noticeMapper.selectById(id);
        NoticeVo noticeVo = NoticeConvert.convertToVoByPo(notice);
        return noticeVo;
    }

    @Override
    public IPage<NoticeVo> selectPage(NoticeQuery noticeQuery){
        QueryWrapper<Notice> queryWrapper=new QueryWrapper<Notice>();
        Page<Notice> page = new Page<>(noticeQuery.getPage(), noticeQuery.getLimit());
        getQueryWrapper(queryWrapper, noticeQuery);
        IPage<Notice> pageNotice = noticeMapper.selectPage(page, queryWrapper);
        IPage<NoticeVo> pageResult = new Page<>();
        pageResult.setRecords(NoticeConvert.convertToVoByPo(pageNotice.getRecords()));
        pageResult.setCurrent(pageNotice.getCurrent());
        pageResult.setSize(pageNotice.getSize());
        pageResult.setTotal(pageNotice.getTotal());
        pageResult.setPages(pageNotice.getPages());
        return pageResult;
    }

    @Override
    public List<NoticeVo> selectList(NoticeQuery noticeQuery){
        QueryWrapper<Notice> queryWrapper=new QueryWrapper<Notice>();
        getQueryWrapper(queryWrapper, noticeQuery);
        List<Notice> list = noticeMapper.selectList(queryWrapper);
        return NoticeConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Notice notice = noticeMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Notice> queryWrapper=new QueryWrapper<Notice>();
        queryWrapper.lambda().in(Notice::getNoticeId, ids);
        List<Notice> notices = noticeMapper.selectList(queryWrapper);
        //BeanUtils.set(notices, Notice::getNoticeId, Notice::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Notice> getQueryWrapper(QueryWrapper<Notice> queryWrapper,NoticeQuery noticeQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
