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
import com.news.hr.system.bean.po.NoticeUser;
import com.news.hr.system.bean.query.NoticeUserQuery;
import com.news.hr.system.bean.form.NoticeUserForm;
import com.news.hr.system.bean.vo.NoticeUserVo;
import com.news.hr.system.bean.convert.NoticeUserConvert;
import com.news.hr.system.mapper.NoticeUserMapper;
import com.news.hr.system.service.NoticeUserService;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeUserServiceImpl extends ServiceImpl<NoticeUserMapper, NoticeUser> implements NoticeUserService {

    @Resource
    private NoticeUserMapper noticeUserMapper;

    @Override
    public Integer save(NoticeUserForm record) {
        NoticeUser noticeUser = NoticeUserConvert.convertToPoByForm(record);
        return noticeUserMapper.insert(noticeUser);
    }

    @Override
    public Integer updateById(NoticeUserForm record) {
        NoticeUser noticeUser = NoticeUserConvert.convertToPoByForm(record);
        return noticeUserMapper.updateById(noticeUser);
    }

    @Override
    public Integer deleteById(String id) {
        return noticeUserMapper.deleteById(id);
    }

    @Override
    public NoticeUserVo selectById(String id) {
        NoticeUser noticeUser = noticeUserMapper.selectById(id);
        NoticeUserVo noticeUserVo = NoticeUserConvert.convertToVoByPo(noticeUser);
        return noticeUserVo;
    }

    @Override
    public IPage<NoticeUserVo> selectPage(NoticeUserQuery noticeUserQuery){
        QueryWrapper<NoticeUser> queryWrapper=new QueryWrapper<NoticeUser>();
        Page<NoticeUser> page = new Page<>(noticeUserQuery.getPage(), noticeUserQuery.getLimit());
        getQueryWrapper(queryWrapper, noticeUserQuery);
        IPage<NoticeUser> pageNoticeUser = noticeUserMapper.selectPage(page, queryWrapper);
        IPage<NoticeUserVo> pageResult = new Page<>();
        pageResult.setRecords(NoticeUserConvert.convertToVoByPo(pageNoticeUser.getRecords()));
        pageResult.setCurrent(pageNoticeUser.getCurrent());
        pageResult.setSize(pageNoticeUser.getSize());
        pageResult.setTotal(pageNoticeUser.getTotal());
        pageResult.setPages(pageNoticeUser.getPages());
        return pageResult;
    }

    @Override
    public List<NoticeUserVo> selectList(NoticeUserQuery noticeUserQuery){
        QueryWrapper<NoticeUser> queryWrapper=new QueryWrapper<NoticeUser>();
        getQueryWrapper(queryWrapper, noticeUserQuery);
        List<NoticeUser> list = noticeUserMapper.selectList(queryWrapper);
        return NoticeUserConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        NoticeUser noticeUser = noticeUserMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<NoticeUser> queryWrapper=new QueryWrapper<NoticeUser>();
        queryWrapper.lambda().in(NoticeUser::getNoticeUserId, ids);
        List<NoticeUser> noticeUsers = noticeUserMapper.selectList(queryWrapper);
        //BeanUtils.set(noticeUsers, NoticeUser::getNoticeUserId, NoticeUser::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<NoticeUser> getQueryWrapper(QueryWrapper<NoticeUser> queryWrapper,NoticeUserQuery noticeUserQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
