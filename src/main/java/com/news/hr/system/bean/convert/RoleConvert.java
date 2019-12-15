package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Role;
import com.news.hr.system.bean.form.RoleForm;
import com.news.hr.system.bean.vo.RoleVo;
import com.news.hr.system.bean.dto.RoleImport;
import com.news.hr.system.bean.dto.RoleExport;
/**
 * <p>
 * RoleConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class RoleConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Role convertToPoByForm(RoleForm source){
        Role target = new Role();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static RoleVo convertToVoByPo(Role source){
        RoleVo target = new RoleVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<RoleVo> convertToVoByPo(List<Role> sources){
        List<RoleVo> roles = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return roles;
        }
        for (Role source : sources) {
            RoleVo target = new RoleVo();
            BeanUtils.copyProperties(source, target);
            roles.add(target);
        }
        return roles;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Role> convertToPoByImport(List<RoleImport> sources){
        List<Role> roles = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return roles;
        }
        for (RoleImport source : sources) {
            Role target = new Role();
            BeanUtils.copyProperties(source, target);
            roles.add(target);
        }
        return roles;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<RoleExport> convertToExportByPo(List<Role> sources){
        List<RoleExport> roleExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return roleExports;
        }
        for (Role source : sources) {
            RoleExport target = new RoleExport();
            BeanUtils.copyProperties(source, target);
            roleExports.add(target);
        }
        return roleExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<RoleExport> convertToExportByVo(List<RoleVo> sources){
        List<RoleExport> roleExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return roleExports;
        }
        for (RoleVo source : sources) {
            RoleExport target = new RoleExport();
            BeanUtils.copyProperties(source, target);
            roleExports.add(target);
        }
        return roleExports;
    }

}