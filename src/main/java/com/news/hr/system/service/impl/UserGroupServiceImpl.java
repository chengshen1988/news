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
import com.news.hr.system.bean.po.UserGroup;
import com.news.hr.system.bean.query.UserGroupQuery;
import com.news.hr.system.bean.form.UserGroupForm;
import com.news.hr.system.bean.vo.UserGroupVo;
import com.news.hr.system.bean.convert.UserGroupConvert;
import com.news.hr.system.mapper.UserGroupMapper;
import com.news.hr.system.service.UserGroupService;
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
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements UserGroupService {

    @Resource
    private UserGroupMapper userGroupMapper;

    @Override
    public Integer save(UserGroupForm record) {
        UserGroup userGroup = UserGroupConvert.convertToPoByForm(record);
        return userGroupMapper.insert(userGroup);
    }

    @Override
    public Integer updateById(UserGroupForm record) {
        UserGroup userGroup = UserGroupConvert.convertToPoByForm(record);
        return userGroupMapper.updateById(userGroup);
    }

    @Override
    public Integer deleteById(String id) {
        return userGroupMapper.deleteById(id);
    }

    @Override
    public UserGroupVo selectById(String id) {
        UserGroup userGroup = userGroupMapper.selectById(id);
        UserGroupVo userGroupVo = UserGroupConvert.convertToVoByPo(userGroup);
        return userGroupVo;
    }

    @Override
    public IPage<UserGroupVo> selectPage(UserGroupQuery userGroupQuery){
        QueryWrapper<UserGroup> queryWrapper=new QueryWrapper<UserGroup>();
        Page<UserGroup> page = new Page<>(userGroupQuery.getPage(), userGroupQuery.getLimit());
        getQueryWrapper(queryWrapper, userGroupQuery);
        IPage<UserGroup> pageUserGroup = userGroupMapper.selectPage(page, queryWrapper);
        IPage<UserGroupVo> pageResult = new Page<>();
        pageResult.setRecords(UserGroupConvert.convertToVoByPo(pageUserGroup.getRecords()));
        pageResult.setCurrent(pageUserGroup.getCurrent());
        pageResult.setSize(pageUserGroup.getSize());
        pageResult.setTotal(pageUserGroup.getTotal());
        pageResult.setPages(pageUserGroup.getPages());
        return pageResult;
    }

    @Override
    public List<UserGroupVo> selectList(UserGroupQuery userGroupQuery){
        QueryWrapper<UserGroup> queryWrapper=new QueryWrapper<UserGroup>();
        getQueryWrapper(queryWrapper, userGroupQuery);
        List<UserGroup> list = userGroupMapper.selectList(queryWrapper);
        return UserGroupConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        UserGroup userGroup = userGroupMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<UserGroup> queryWrapper=new QueryWrapper<UserGroup>();
        queryWrapper.lambda().in(UserGroup::getUserGroupId, ids);
        List<UserGroup> userGroups = userGroupMapper.selectList(queryWrapper);
        //BeanUtils.set(userGroups, UserGroup::getUserGroupId, UserGroup::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<UserGroup> getQueryWrapper(QueryWrapper<UserGroup> queryWrapper,UserGroupQuery userGroupQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
