package com.news.hr.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.news.hr.framework.utils.BeanUtils;
import com.news.hr.system.bean.convert.UserRoleConvert;
import com.news.hr.system.bean.form.UserRoleForm;
import com.news.hr.system.bean.po.UserRole;
import com.news.hr.system.bean.query.UserRoleQuery;
import com.news.hr.system.bean.vo.UserRoleVo;
import com.news.hr.system.mapper.UserRoleMapper;
import com.news.hr.system.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public Integer save(UserRoleForm record) {
        UserRole userRole = UserRoleConvert.convertToPoByForm(record);
        return userRoleMapper.insert(userRole);
    }

    @Override
    public Integer updateById(UserRoleForm record) {
        UserRole userRole = UserRoleConvert.convertToPoByForm(record);
        return userRoleMapper.updateById(userRole);
    }

    @Override
    public Integer deleteById(String id) {
        return userRoleMapper.deleteById(id);
    }

    @Override
    public UserRoleVo selectById(String id) {
        UserRole userRole = userRoleMapper.selectById(id);
        UserRoleVo userRoleVo = UserRoleConvert.convertToVoByPo(userRole);
        return userRoleVo;
    }

    @Override
    public IPage<UserRoleVo> selectPage(UserRoleQuery userRoleQuery){
        QueryWrapper<UserRole> queryWrapper=new QueryWrapper<UserRole>();
        Page<UserRole> page = new Page<>(userRoleQuery.getPage(), userRoleQuery.getLimit());
        getQueryWrapper(queryWrapper, userRoleQuery);
        IPage<UserRole> pageUserRole = userRoleMapper.selectPage(page, queryWrapper);
        IPage<UserRoleVo> pageResult = new Page<>();
        pageResult.setRecords(UserRoleConvert.convertToVoByPo(pageUserRole.getRecords()));
        pageResult.setCurrent(pageUserRole.getCurrent());
        pageResult.setSize(pageUserRole.getSize());
        pageResult.setTotal(pageUserRole.getTotal());
        pageResult.setPages(pageUserRole.getPages());
        return pageResult;
    }

    @Override
    public List<UserRoleVo> selectList(UserRoleQuery userRoleQuery){
        QueryWrapper<UserRole> queryWrapper=new QueryWrapper<UserRole>();
        getQueryWrapper(queryWrapper, userRoleQuery);
        List<UserRole> list = userRoleMapper.selectList(queryWrapper);
        
        return UserRoleConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        UserRole userRole = userRoleMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<UserRole> queryWrapper=new QueryWrapper<UserRole>();
        queryWrapper.lambda().in(UserRole::getUserRoleId, ids);
        List<UserRole> userRoles = userRoleMapper.selectList(queryWrapper);
        //BeanUtils.set(userRoles, UserRole::getUserRoleId, UserRole::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<UserRole> getQueryWrapper(QueryWrapper<UserRole> queryWrapper,UserRoleQuery userRoleQuery){
        queryWrapper.lambda()
                .eq(StrUtil.isNotBlank(userRoleQuery.getUserId()),UserRole::getUserId,userRoleQuery.getUserId())
                .eq(StrUtil.isNotBlank(userRoleQuery.getRoleId()),UserRole::getRoleId,userRoleQuery.getRoleId())
                .eq(StrUtil.isNotBlank(userRoleQuery.getUserRoleId()),UserRole::getUserRoleId,userRoleQuery.getUserRoleId())
                ;
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
