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
import com.news.hr.system.bean.po.Menu;
import com.news.hr.system.bean.query.MenuQuery;
import com.news.hr.system.bean.form.MenuForm;
import com.news.hr.system.bean.vo.MenuVo;
import com.news.hr.system.bean.convert.MenuConvert;
import com.news.hr.system.mapper.MenuMapper;
import com.news.hr.system.service.MenuService;
/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public Integer save(MenuForm record) {
        Menu menu = MenuConvert.convertToPoByForm(record);
        return menuMapper.insert(menu);
    }

    @Override
    public Integer updateById(MenuForm record) {
        Menu menu = MenuConvert.convertToPoByForm(record);
        return menuMapper.updateById(menu);
    }

    @Override
    public Integer deleteById(String id) {
        return menuMapper.deleteById(id);
    }

    @Override
    public MenuVo selectById(String id) {
        Menu menu = menuMapper.selectById(id);
        MenuVo menuVo = MenuConvert.convertToVoByPo(menu);
        return menuVo;
    }

    @Override
    public IPage<MenuVo> selectPage(MenuQuery menuQuery){
        QueryWrapper<Menu> queryWrapper=new QueryWrapper<Menu>();
        Page<Menu> page = new Page<>(menuQuery.getPage(), menuQuery.getLimit());
        getQueryWrapper(queryWrapper, menuQuery);
        IPage<Menu> pageMenu = menuMapper.selectPage(page, queryWrapper);
        IPage<MenuVo> pageResult = new Page<>();
        pageResult.setRecords(MenuConvert.convertToVoByPo(pageMenu.getRecords()));
        pageResult.setCurrent(pageMenu.getCurrent());
        pageResult.setSize(pageMenu.getSize());
        pageResult.setTotal(pageMenu.getTotal());
        pageResult.setPages(pageMenu.getPages());
        return pageResult;
    }

    @Override
    public List<MenuVo> selectList(MenuQuery menuQuery){
        QueryWrapper<Menu> queryWrapper=new QueryWrapper<Menu>();
        getQueryWrapper(queryWrapper, menuQuery);
        List<Menu> list = menuMapper.selectList(queryWrapper);
        return MenuConvert.convertToVoByPo(list);
    }


    @Override
    public <T> void doSetName(T t, Function<T, String> f, BiConsumer<T, String> c) {
        String id = BeanUtils.get(f, t);
        Menu menu = menuMapper.selectById(id);
        //BeanUtils.set(role, Role::getRoleId, Role::getRoleName, t, f, c);
    }

    @Override
    public <T> void doSetName(List<T> l, Function<T, String> f, BiConsumer<T, String> c) {
        List<String> ids = BeanUtils.distinct(l, f);
        QueryWrapper<Menu> queryWrapper=new QueryWrapper<Menu>();
        queryWrapper.lambda().in(Menu::getMenuId, ids);
        List<Menu> menus = menuMapper.selectList(queryWrapper);
        //BeanUtils.set(menus, Menu::getMenuId, Menu::getName, l, f, c);
    }

    /**
     *  公共查询条件
     * @param queryWrapper
     * @return
     */
    @Override
    public QueryWrapper<Menu> getQueryWrapper(QueryWrapper<Menu> queryWrapper,MenuQuery menuQuery){
        return queryWrapper;
    }

    /*******************通用方法结束**********************/

}
