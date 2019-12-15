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
import com.news.hr.system.bean.po.Message;
import com.news.hr.system.bean.query.MessageQuery;
import com.news.hr.system.bean.form.MessageForm;
import com.news.hr.system.bean.vo.MessageVo;
import com.news.hr.system.bean.convert.MessageConvert;
import com.news.hr.system.mapper.MessageMapper;
import com.news.hr.system.service.MessageService;
/**
 * <p>
 * 系统消息 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public Integer save(MessageForm record) {
        Message message = MessageConvert.convertToPoByForm(record);
        return messageMapper.insert(message);
    }

    @Override
    public Integer updateById(MessageForm record) {
        Message message = MessageConvert.convertToPoByForm(record);
        return messageMapper.updateById(message);
    }

    @Override
    public Integer deleteById(String id) {
        return messageMapper.deleteById(id);
    }

    @Override
    public MessageVo selectById(String id) {
        Message message = messageMapper.selectById(id);
        MessageVo messageVo = MessageConvert.convertToVoByPo(message);
        return messageVo;
    }

    @Override
    public IPage<MessageVo> selectPage(MessageQuery messageQuery){
        QueryWrapper<Message> queryWrapper=new QueryWrapper<Message>();
        Page<Message> page = new Page<>(messageQuery.getPage(), messageQuery.getLimit());
        getQueryWrapper(queryWrapper, messageQuery);
        IPage<Message> pageMessage = messageMapper.selectPage(page, queryWrapper);
        IPage<MessageVo> pageResult = new Page<>();
        pageResult.setRecords(MessageConvert.convertToVoByPo(pageMessage.getRecords()));
        pageResult.setCurrent(pageMessage.getCurrent());
        pageResult.setSize(pageMessage.getSize());
        pageResult.setTotal(pageMessage.getTotal());
        pageResult.setPages(pageMessage.getPages());
        return pageResult;
    }

    @Override
    public List<MessageVo> selectList(MessageQuery messageQuery){
        QueryWrapper<Message> queryWrapper=new QueryWrapper<Message>();
        getQueryWrapper(queryWrapper, messageQuery);
        List<Message> list = messageMapper.selectList(queryWrapper);
        return MessageConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Message message = messageMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Message> queryWrapper=new QueryWrapper<Message>();
        queryWrapper.lambda().in(Message::getMessageId, ids);
        List<Message> messages = messageMapper.selectList(queryWrapper);
        //BeanUtils.set(messages, Message::getMessageId, Message::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Message> getQueryWrapper(QueryWrapper<Message> queryWrapper,MessageQuery messageQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
