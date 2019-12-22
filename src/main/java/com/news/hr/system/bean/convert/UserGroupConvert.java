package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.UserGroup;
import com.news.hr.system.bean.form.UserGroupForm;
import com.news.hr.system.bean.vo.UserGroupVo;
import com.news.hr.system.bean.dto.UserGroupImport;
import com.news.hr.system.bean.dto.UserGroupExport;
/**
 * <p>
 * UserGroupConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class UserGroupConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static UserGroup convertToPoByForm(UserGroupForm source){
        UserGroup target = new UserGroup();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static UserGroupVo convertToVoByPo(UserGroup source){
        UserGroupVo target = new UserGroupVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<UserGroupVo> convertToVoByPo(List<UserGroup> sources){
        List<UserGroupVo> userGroups = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return userGroups;
        }
        for (UserGroup source : sources) {
            UserGroupVo target = new UserGroupVo();
            BeanUtils.copyProperties(source, target);
            userGroups.add(target);
        }
        return userGroups;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<UserGroup> convertToPoByImport(List<UserGroupImport> sources){
        List<UserGroup> userGroups = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return userGroups;
        }
        for (UserGroupImport source : sources) {
            UserGroup target = new UserGroup();
            BeanUtils.copyProperties(source, target);
            userGroups.add(target);
        }
        return userGroups;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<UserGroupExport> convertToExportByPo(List<UserGroup> sources){
        List<UserGroupExport> userGroupExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return userGroupExports;
        }
        for (UserGroup source : sources) {
            UserGroupExport target = new UserGroupExport();
            BeanUtils.copyProperties(source, target);
            userGroupExports.add(target);
        }
        return userGroupExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<UserGroupExport> convertToExportByVo(List<UserGroupVo> sources){
        List<UserGroupExport> userGroupExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return userGroupExports;
        }
        for (UserGroupVo source : sources) {
            UserGroupExport target = new UserGroupExport();
            BeanUtils.copyProperties(source, target);
            userGroupExports.add(target);
        }
        return userGroupExports;
    }

}