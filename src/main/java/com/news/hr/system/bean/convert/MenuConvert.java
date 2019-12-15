package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Menu;
import com.news.hr.system.bean.form.MenuForm;
import com.news.hr.system.bean.vo.MenuVo;
import com.news.hr.system.bean.dto.MenuImport;
import com.news.hr.system.bean.dto.MenuExport;
/**
 * <p>
 * MenuConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class MenuConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Menu convertToPoByForm(MenuForm source){
        Menu target = new Menu();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static MenuVo convertToVoByPo(Menu source){
        MenuVo target = new MenuVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<MenuVo> convertToVoByPo(List<Menu> sources){
        List<MenuVo> menus = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return menus;
        }
        for (Menu source : sources) {
            MenuVo target = new MenuVo();
            BeanUtils.copyProperties(source, target);
            menus.add(target);
        }
        return menus;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Menu> convertToPoByImport(List<MenuImport> sources){
        List<Menu> menus = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return menus;
        }
        for (MenuImport source : sources) {
            Menu target = new Menu();
            BeanUtils.copyProperties(source, target);
            menus.add(target);
        }
        return menus;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<MenuExport> convertToExportByPo(List<Menu> sources){
        List<MenuExport> menuExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return menuExports;
        }
        for (Menu source : sources) {
            MenuExport target = new MenuExport();
            BeanUtils.copyProperties(source, target);
            menuExports.add(target);
        }
        return menuExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<MenuExport> convertToExportByVo(List<MenuVo> sources){
        List<MenuExport> menuExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return menuExports;
        }
        for (MenuVo source : sources) {
            MenuExport target = new MenuExport();
            BeanUtils.copyProperties(source, target);
            menuExports.add(target);
        }
        return menuExports;
    }

}