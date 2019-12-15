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
import com.news.hr.system.bean.po.Permission;
import com.news.hr.system.bean.query.PermissionQuery;
import com.news.hr.system.bean.form.PermissionForm;
import com.news.hr.system.bean.vo.PermissionVo;
import com.news.hr.system.bean.convert.PermissionConvert;
import com.news.hr.system.mapper.PermissionMapper;
import com.news.hr.system.service.PermissionService;
/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public Integer save(PermissionForm record) {
        Permission permission = PermissionConvert.convertToPoByForm(record);
        return permissionMapper.insert(permission);
    }

    @Override
    public Integer updateById(PermissionForm record) {
        Permission permission = PermissionConvert.convertToPoByForm(record);
        return permissionMapper.updateById(permission);
    }

    @Override
    public Integer deleteById(String id) {
        return permissionMapper.deleteById(id);
    }

    @Override
    public PermissionVo selectById(String id) {
        Permission permission = permissionMapper.selectById(id);
        PermissionVo permissionVo = PermissionConvert.convertToVoByPo(permission);
        return permissionVo;
    }

    @Override
    public IPage<PermissionVo> selectPage(PermissionQuery permissionQuery){
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<Permission>();
        Page<Permission> page = new Page<>(permissionQuery.getPage(), permissionQuery.getLimit());
        getQueryWrapper(queryWrapper, permissionQuery);
        IPage<Permission> pagePermission = permissionMapper.selectPage(page, queryWrapper);
        IPage<PermissionVo> pageResult = new Page<>();
        pageResult.setRecords(PermissionConvert.convertToVoByPo(pagePermission.getRecords()));
        pageResult.setCurrent(pagePermission.getCurrent());
        pageResult.setSize(pagePermission.getSize());
        pageResult.setTotal(pagePermission.getTotal());
        pageResult.setPages(pagePermission.getPages());
        return pageResult;
    }

    @Override
    public List<PermissionVo> selectList(PermissionQuery permissionQuery){
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<Permission>();
        getQueryWrapper(queryWrapper, permissionQuery);
        List<Permission> list = permissionMapper.selectList(queryWrapper);
        return PermissionConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Permission permission = permissionMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<Permission>();
        queryWrapper.lambda().in(Permission::getPermissionId, ids);
        List<Permission> permissions = permissionMapper.selectList(queryWrapper);
        //BeanUtils.set(permissions, Permission::getPermissionId, Permission::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Permission> getQueryWrapper(QueryWrapper<Permission> queryWrapper,PermissionQuery permissionQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
