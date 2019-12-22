package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Org;
import com.news.hr.system.bean.form.OrgForm;
import com.news.hr.system.bean.vo.OrgVo;
import com.news.hr.system.bean.dto.OrgImport;
import com.news.hr.system.bean.dto.OrgExport;
/**
 * <p>
 * OrgConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class OrgConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Org convertToPoByForm(OrgForm source){
        Org target = new Org();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static OrgVo convertToVoByPo(Org source){
        OrgVo target = new OrgVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<OrgVo> convertToVoByPo(List<Org> sources){
        List<OrgVo> orgs = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return orgs;
        }
        for (Org source : sources) {
            OrgVo target = new OrgVo();
            BeanUtils.copyProperties(source, target);
            orgs.add(target);
        }
        return orgs;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Org> convertToPoByImport(List<OrgImport> sources){
        List<Org> orgs = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return orgs;
        }
        for (OrgImport source : sources) {
            Org target = new Org();
            BeanUtils.copyProperties(source, target);
            orgs.add(target);
        }
        return orgs;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<OrgExport> convertToExportByPo(List<Org> sources){
        List<OrgExport> orgExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return orgExports;
        }
        for (Org source : sources) {
            OrgExport target = new OrgExport();
            BeanUtils.copyProperties(source, target);
            orgExports.add(target);
        }
        return orgExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<OrgExport> convertToExportByVo(List<OrgVo> sources){
        List<OrgExport> orgExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return orgExports;
        }
        for (OrgVo source : sources) {
            OrgExport target = new OrgExport();
            BeanUtils.copyProperties(source, target);
            orgExports.add(target);
        }
        return orgExports;
    }

}