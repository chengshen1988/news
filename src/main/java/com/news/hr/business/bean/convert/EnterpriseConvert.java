package com.news.hr.business.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.business.bean.po.Enterprise;
import com.news.hr.business.bean.form.EnterpriseForm;
import com.news.hr.business.bean.vo.EnterpriseVo;
import com.news.hr.business.bean.dto.EnterpriseImport;
import com.news.hr.business.bean.dto.EnterpriseExport;
/**
 * <p>
 * EnterpriseConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class EnterpriseConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Enterprise convertToPoByForm(EnterpriseForm source){
        Enterprise target = new Enterprise();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static EnterpriseVo convertToVoByPo(Enterprise source){
        EnterpriseVo target = new EnterpriseVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<EnterpriseVo> convertToVoByPo(List<Enterprise> sources){
        List<EnterpriseVo> enterprises = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return enterprises;
        }
        for (Enterprise source : sources) {
            EnterpriseVo target = new EnterpriseVo();
            BeanUtils.copyProperties(source, target);
            enterprises.add(target);
        }
        return enterprises;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Enterprise> convertToPoByImport(List<EnterpriseImport> sources){
        List<Enterprise> enterprises = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return enterprises;
        }
        for (EnterpriseImport source : sources) {
            Enterprise target = new Enterprise();
            BeanUtils.copyProperties(source, target);
            enterprises.add(target);
        }
        return enterprises;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<EnterpriseExport> convertToExportByPo(List<Enterprise> sources){
        List<EnterpriseExport> enterpriseExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return enterpriseExports;
        }
        for (Enterprise source : sources) {
            EnterpriseExport target = new EnterpriseExport();
            BeanUtils.copyProperties(source, target);
            enterpriseExports.add(target);
        }
        return enterpriseExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<EnterpriseExport> convertToExportByVo(List<EnterpriseVo> sources){
        List<EnterpriseExport> enterpriseExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return enterpriseExports;
        }
        for (EnterpriseVo source : sources) {
            EnterpriseExport target = new EnterpriseExport();
            BeanUtils.copyProperties(source, target);
            enterpriseExports.add(target);
        }
        return enterpriseExports;
    }

}