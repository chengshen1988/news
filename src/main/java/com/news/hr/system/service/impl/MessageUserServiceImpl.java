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
import com.news.hr.system.bean.po.MessageUser;
import com.news.hr.system.bean.query.MessageUserQuery;
import com.news.hr.system.bean.form.MessageUserForm;
import com.news.hr.system.bean.vo.MessageUserVo;
import com.news.hr.system.bean.convert.MessageUserConvert;
import com.news.hr.system.mapper.MessageUserMapper;
import com.news.hr.system.service.MessageUserService;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional
public class MessageUserServiceImpl extends ServiceImpl<MessageUserMapper, MessageUser> implements MessageUserService {

    @Resource
    private MessageUserMapper messageUserMapper;

    @Override
    public Integer save(MessageUserForm record) {
        MessageUser messageUser = MessageUserConvert.convertToPoByForm(record);
        return messageUserMapper.insert(messageUser);
    }

    @Override
    public Integer updateById(MessageUserForm record) {
        MessageUser messageUser = MessageUserConvert.convertToPoByForm(record);
        return messageUserMapper.updateById(messageUser);
    }

    @Override
    public Integer deleteById(String id) {
        return messageUserMapper.deleteById(id);
    }

    @Override
    public MessageUserVo selectById(String id) {
        MessageUser messageUser = messageUserMapper.selectById(id);
        MessageUserVo messageUserVo = MessageUserConvert.convertToVoByPo(messageUser);
        return messageUserVo;
    }

    @Override
    public IPage<MessageUserVo> selectPage(MessageUserQuery messageUserQuery){
        QueryWrapper<MessageUser> queryWrapper=new QueryWrapper<MessageUser>();
        Page<MessageUser> page = new Page<>(messageUserQuery.getPage(), messageUserQuery.getLimit());
        getQueryWrapper(queryWrapper, messageUserQuery);
        IPage<MessageUser> pageMessageUser = messageUserMapper.selectPage(page, queryWrapper);
        IPage<MessageUserVo> pageResult = new Page<>();
        pageResult.setRecords(MessageUserConvert.convertToVoByPo(pageMessageUser.getRecords()));
        pageResult.setCurrent(pageMessageUser.getCurrent());
        pageResult.setSize(pageMessageUser.getSize());
        pageResult.setTotal(pageMessageUser.getTotal());
        pageResult.setPages(pageMessageUser.getPages());
        return pageResult;
    }

    @Override
    public List<MessageUserVo> selectList(MessageUserQuery messageUserQuery){
        QueryWrapper<MessageUser> queryWrapper=new QueryWrapper<MessageUser>();
        getQueryWrapper(queryWrapper, messageUserQuery);
        List<MessageUser> list = messageUserMapper.selectList(queryWrapper);
        return MessageUserConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        MessageUser messageUser = messageUserMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<MessageUser> queryWrapper=new QueryWrapper<MessageUser>();
        queryWrapper.lambda().in(MessageUser::getMessageUserId, ids);
        List<MessageUser> messageUsers = messageUserMapper.selectList(queryWrapper);
        //BeanUtils.set(messageUsers, MessageUser::getMessageUserId, MessageUser::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<MessageUser> getQueryWrapper(QueryWrapper<MessageUser> queryWrapper,MessageUserQuery messageUserQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
