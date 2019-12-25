package com.news.hr.business.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.business.bean.po.LinkManage;
import com.news.hr.business.bean.form.LinkManageForm;
import com.news.hr.business.bean.vo.LinkManageVo;
import com.news.hr.business.bean.dto.LinkManageImport;
import com.news.hr.business.bean.dto.LinkManageExport;
/**
 * <p>
 * LinkManageConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class LinkManageConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static LinkManage convertToPoByForm(LinkManageForm source){
        LinkManage target = new LinkManage();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static LinkManageVo convertToVoByPo(LinkManage source){
        LinkManageVo target = new LinkManageVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<LinkManageVo> convertToVoByPo(List<LinkManage> sources){
        List<LinkManageVo> linkManages = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return linkManages;
        }
        for (LinkManage source : sources) {
            LinkManageVo target = new LinkManageVo();
            BeanUtils.copyProperties(source, target);
            linkManages.add(target);
        }
        return linkManages;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<LinkManage> convertToPoByImport(List<LinkManageImport> sources){
        List<LinkManage> linkManages = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return linkManages;
        }
        for (LinkManageImport source : sources) {
            LinkManage target = new LinkManage();
            BeanUtils.copyProperties(source, target);
            linkManages.add(target);
        }
        return linkManages;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<LinkManageExport> convertToExportByPo(List<LinkManage> sources){
        List<LinkManageExport> linkManageExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return linkManageExports;
        }
        for (LinkManage source : sources) {
            LinkManageExport target = new LinkManageExport();
            BeanUtils.copyProperties(source, target);
            linkManageExports.add(target);
        }
        return linkManageExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<LinkManageExport> convertToExportByVo(List<LinkManageVo> sources){
        List<LinkManageExport> linkManageExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return linkManageExports;
        }
        for (LinkManageVo source : sources) {
            LinkManageExport target = new LinkManageExport();
            BeanUtils.copyProperties(source, target);
            linkManageExports.add(target);
        }
        return linkManageExports;
    }

}