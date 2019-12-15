package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.User;
import com.news.hr.system.bean.form.UserForm;
import com.news.hr.system.bean.vo.UserVo;
import com.news.hr.system.bean.dto.UserImport;
import com.news.hr.system.bean.dto.UserExport;
/**
 * <p>
 * UserConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class UserConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static User convertToPoByForm(UserForm source){
        User target = new User();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static UserVo convertToVoByPo(User source){
        UserVo target = new UserVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<UserVo> convertToVoByPo(List<User> sources){
        List<UserVo> users = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return users;
        }
        for (User source : sources) {
            UserVo target = new UserVo();
            BeanUtils.copyProperties(source, target);
            users.add(target);
        }
        return users;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<User> convertToPoByImport(List<UserImport> sources){
        List<User> users = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return users;
        }
        for (UserImport source : sources) {
            User target = new User();
            BeanUtils.copyProperties(source, target);
            users.add(target);
        }
        return users;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<UserExport> convertToExportByPo(List<User> sources){
        List<UserExport> userExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return userExports;
        }
        for (User source : sources) {
            UserExport target = new UserExport();
            BeanUtils.copyProperties(source, target);
            userExports.add(target);
        }
        return userExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<UserExport> convertToExportByVo(List<UserVo> sources){
        List<UserExport> userExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return userExports;
        }
        for (UserVo source : sources) {
            UserExport target = new UserExport();
            BeanUtils.copyProperties(source, target);
            userExports.add(target);
        }
        return userExports;
    }

}