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
import com.news.hr.system.bean.po.Role;
import com.news.hr.system.bean.query.RoleQuery;
import com.news.hr.system.bean.form.RoleForm;
import com.news.hr.system.bean.vo.RoleVo;
import com.news.hr.system.bean.convert.RoleConvert;
import com.news.hr.system.mapper.RoleMapper;
import com.news.hr.system.service.RoleService;
/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Integer save(RoleForm record) {
        Role role = RoleConvert.convertToPoByForm(record);
        return roleMapper.insert(role);
    }

    @Override
    public Integer updateById(RoleForm record) {
        Role role = RoleConvert.convertToPoByForm(record);
        return roleMapper.updateById(role);
    }

    @Override
    public Integer deleteById(String id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public RoleVo selectById(String id) {
        Role role = roleMapper.selectById(id);
        RoleVo roleVo = RoleConvert.convertToVoByPo(role);
        return roleVo;
    }

    @Override
    public IPage<RoleVo> selectPage(RoleQuery roleQuery){
        QueryWrapper<Role> queryWrapper=new QueryWrapper<Role>();
        Page<Role> page = new Page<>(roleQuery.getPage(), roleQuery.getLimit());
        getQueryWrapper(queryWrapper, roleQuery);
        IPage<Role> pageRole = roleMapper.selectPage(page, queryWrapper);
        IPage<RoleVo> pageResult = new Page<>();
        pageResult.setRecords(RoleConvert.convertToVoByPo(pageRole.getRecords()));
        pageResult.setCurrent(pageRole.getCurrent());
        pageResult.setSize(pageRole.getSize());
        pageResult.setTotal(pageRole.getTotal());
        pageResult.setPages(pageRole.getPages());
        return pageResult;
    }

    @Override
    public List<RoleVo> selectList(RoleQuery roleQuery){
        QueryWrapper<Role> queryWrapper=new QueryWrapper<Role>();
        getQueryWrapper(queryWrapper, roleQuery);
        List<Role> list = roleMapper.selectList(queryWrapper);
        return RoleConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Role role = roleMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Role> queryWrapper=new QueryWrapper<Role>();
        queryWrapper.lambda().in(Role::getRoleId, ids);
        List<Role> roles = roleMapper.selectList(queryWrapper);
        //BeanUtils.set(roles, Role::getRoleId, Role::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Role> getQueryWrapper(QueryWrapper<Role> queryWrapper,RoleQuery roleQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
