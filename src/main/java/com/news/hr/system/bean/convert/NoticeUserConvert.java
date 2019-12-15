package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.NoticeUser;
import com.news.hr.system.bean.form.NoticeUserForm;
import com.news.hr.system.bean.vo.NoticeUserVo;
import com.news.hr.system.bean.dto.NoticeUserImport;
import com.news.hr.system.bean.dto.NoticeUserExport;
/**
 * <p>
 * NoticeUserConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class NoticeUserConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static NoticeUser convertToPoByForm(NoticeUserForm source){
        NoticeUser target = new NoticeUser();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static NoticeUserVo convertToVoByPo(NoticeUser source){
        NoticeUserVo target = new NoticeUserVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<NoticeUserVo> convertToVoByPo(List<NoticeUser> sources){
        List<NoticeUserVo> noticeUsers = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return noticeUsers;
        }
        for (NoticeUser source : sources) {
            NoticeUserVo target = new NoticeUserVo();
            BeanUtils.copyProperties(source, target);
            noticeUsers.add(target);
        }
        return noticeUsers;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<NoticeUser> convertToPoByImport(List<NoticeUserImport> sources){
        List<NoticeUser> noticeUsers = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return noticeUsers;
        }
        for (NoticeUserImport source : sources) {
            NoticeUser target = new NoticeUser();
            BeanUtils.copyProperties(source, target);
            noticeUsers.add(target);
        }
        return noticeUsers;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<NoticeUserExport> convertToExportByPo(List<NoticeUser> sources){
        List<NoticeUserExport> noticeUserExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return noticeUserExports;
        }
        for (NoticeUser source : sources) {
            NoticeUserExport target = new NoticeUserExport();
            BeanUtils.copyProperties(source, target);
            noticeUserExports.add(target);
        }
        return noticeUserExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<NoticeUserExport> convertToExportByVo(List<NoticeUserVo> sources){
        List<NoticeUserExport> noticeUserExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return noticeUserExports;
        }
        for (NoticeUserVo source : sources) {
            NoticeUserExport target = new NoticeUserExport();
            BeanUtils.copyProperties(source, target);
            noticeUserExports.add(target);
        }
        return noticeUserExports;
    }

}