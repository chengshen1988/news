package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.UserRole;
import com.news.hr.system.bean.form.UserRoleForm;
import com.news.hr.system.bean.vo.UserRoleVo;
import com.news.hr.system.bean.dto.UserRoleImport;
import com.news.hr.system.bean.dto.UserRoleExport;
/**
 * <p>
 * UserRoleConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class UserRoleConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static UserRole convertToPoByForm(UserRoleForm source){
        UserRole target = new UserRole();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static UserRoleVo convertToVoByPo(UserRole source){
        UserRoleVo target = new UserRoleVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<UserRoleVo> convertToVoByPo(List<UserRole> sources){
        List<UserRoleVo> userRoles = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return userRoles;
        }
        for (UserRole source : sources) {
            UserRoleVo target = new UserRoleVo();
            BeanUtils.copyProperties(source, target);
            userRoles.add(target);
        }
        return userRoles;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<UserRole> convertToPoByImport(List<UserRoleImport> sources){
        List<UserRole> userRoles = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return userRoles;
        }
        for (UserRoleImport source : sources) {
            UserRole target = new UserRole();
            BeanUtils.copyProperties(source, target);
            userRoles.add(target);
        }
        return userRoles;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<UserRoleExport> convertToExportByPo(List<UserRole> sources){
        List<UserRoleExport> userRoleExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return userRoleExports;
        }
        for (UserRole source : sources) {
            UserRoleExport target = new UserRoleExport();
            BeanUtils.copyProperties(source, target);
            userRoleExports.add(target);
        }
        return userRoleExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<UserRoleExport> convertToExportByVo(List<UserRoleVo> sources){
        List<UserRoleExport> userRoleExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return userRoleExports;
        }
        for (UserRoleVo source : sources) {
            UserRoleExport target = new UserRoleExport();
            BeanUtils.copyProperties(source, target);
            userRoleExports.add(target);
        }
        return userRoleExports;
    }

}