package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Permission;
import com.news.hr.system.bean.form.PermissionForm;
import com.news.hr.system.bean.vo.PermissionVo;
import com.news.hr.system.bean.dto.PermissionImport;
import com.news.hr.system.bean.dto.PermissionExport;
/**
 * <p>
 * PermissionConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class PermissionConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Permission convertToPoByForm(PermissionForm source){
        Permission target = new Permission();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static PermissionVo convertToVoByPo(Permission source){
        PermissionVo target = new PermissionVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<PermissionVo> convertToVoByPo(List<Permission> sources){
        List<PermissionVo> permissions = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return permissions;
        }
        for (Permission source : sources) {
            PermissionVo target = new PermissionVo();
            BeanUtils.copyProperties(source, target);
            permissions.add(target);
        }
        return permissions;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Permission> convertToPoByImport(List<PermissionImport> sources){
        List<Permission> permissions = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return permissions;
        }
        for (PermissionImport source : sources) {
            Permission target = new Permission();
            BeanUtils.copyProperties(source, target);
            permissions.add(target);
        }
        return permissions;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<PermissionExport> convertToExportByPo(List<Permission> sources){
        List<PermissionExport> permissionExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return permissionExports;
        }
        for (Permission source : sources) {
            PermissionExport target = new PermissionExport();
            BeanUtils.copyProperties(source, target);
            permissionExports.add(target);
        }
        return permissionExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<PermissionExport> convertToExportByVo(List<PermissionVo> sources){
        List<PermissionExport> permissionExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return permissionExports;
        }
        for (PermissionVo source : sources) {
            PermissionExport target = new PermissionExport();
            BeanUtils.copyProperties(source, target);
            permissionExports.add(target);
        }
        return permissionExports;
    }

}