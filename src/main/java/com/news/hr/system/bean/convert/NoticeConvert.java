package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Notice;
import com.news.hr.system.bean.form.NoticeForm;
import com.news.hr.system.bean.vo.NoticeVo;
import com.news.hr.system.bean.dto.NoticeImport;
import com.news.hr.system.bean.dto.NoticeExport;
/**
 * <p>
 * NoticeConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class NoticeConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Notice convertToPoByForm(NoticeForm source){
        Notice target = new Notice();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static NoticeVo convertToVoByPo(Notice source){
        NoticeVo target = new NoticeVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<NoticeVo> convertToVoByPo(List<Notice> sources){
        List<NoticeVo> notices = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return notices;
        }
        for (Notice source : sources) {
            NoticeVo target = new NoticeVo();
            BeanUtils.copyProperties(source, target);
            notices.add(target);
        }
        return notices;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Notice> convertToPoByImport(List<NoticeImport> sources){
        List<Notice> notices = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return notices;
        }
        for (NoticeImport source : sources) {
            Notice target = new Notice();
            BeanUtils.copyProperties(source, target);
            notices.add(target);
        }
        return notices;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<NoticeExport> convertToExportByPo(List<Notice> sources){
        List<NoticeExport> noticeExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return noticeExports;
        }
        for (Notice source : sources) {
            NoticeExport target = new NoticeExport();
            BeanUtils.copyProperties(source, target);
            noticeExports.add(target);
        }
        return noticeExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<NoticeExport> convertToExportByVo(List<NoticeVo> sources){
        List<NoticeExport> noticeExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return noticeExports;
        }
        for (NoticeVo source : sources) {
            NoticeExport target = new NoticeExport();
            BeanUtils.copyProperties(source, target);
            noticeExports.add(target);
        }
        return noticeExports;
    }

}