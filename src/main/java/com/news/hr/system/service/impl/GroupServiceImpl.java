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
import com.news.hr.system.bean.po.Group;
import com.news.hr.system.bean.query.GroupQuery;
import com.news.hr.system.bean.form.GroupForm;
import com.news.hr.system.bean.vo.GroupVo;
import com.news.hr.system.bean.convert.GroupConvert;
import com.news.hr.system.mapper.GroupMapper;
import com.news.hr.system.service.GroupService;
/**
 * <p>
 * 用户组 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {

    @Resource
    private GroupMapper groupMapper;

    @Override
    public Integer save(GroupForm record) {
        Group group = GroupConvert.convertToPoByForm(record);
        return groupMapper.insert(group);
    }

    @Override
    public Integer updateById(GroupForm record) {
        Group group = GroupConvert.convertToPoByForm(record);
        return groupMapper.updateById(group);
    }

    @Override
    public Integer deleteById(String id) {
        return groupMapper.deleteById(id);
    }

    @Override
    public GroupVo selectById(String id) {
        Group group = groupMapper.selectById(id);
        GroupVo groupVo = GroupConvert.convertToVoByPo(group);
        return groupVo;
    }

    @Override
    public IPage<GroupVo> selectPage(GroupQuery groupQuery){
        QueryWrapper<Group> queryWrapper=new QueryWrapper<Group>();
        Page<Group> page = new Page<>(groupQuery.getPage(), groupQuery.getLimit());
        getQueryWrapper(queryWrapper, groupQuery);
        IPage<Group> pageGroup = groupMapper.selectPage(page, queryWrapper);
        IPage<GroupVo> pageResult = new Page<>();
        pageResult.setRecords(GroupConvert.convertToVoByPo(pageGroup.getRecords()));
        pageResult.setCurrent(pageGroup.getCurrent());
        pageResult.setSize(pageGroup.getSize());
        pageResult.setTotal(pageGroup.getTotal());
        pageResult.setPages(pageGroup.getPages());
        return pageResult;
    }

    @Override
    public List<GroupVo> selectList(GroupQuery groupQuery){
        QueryWrapper<Group> queryWrapper=new QueryWrapper<Group>();
        getQueryWrapper(queryWrapper, groupQuery);
        List<Group> list = groupMapper.selectList(queryWrapper);
        return GroupConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Group group = groupMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Group> queryWrapper=new QueryWrapper<Group>();
        queryWrapper.lambda().in(Group::getGroupId, ids);
        List<Group> groups = groupMapper.selectList(queryWrapper);
        //BeanUtils.set(groups, Group::getGroupId, Group::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Group> getQueryWrapper(QueryWrapper<Group> queryWrapper,GroupQuery groupQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
