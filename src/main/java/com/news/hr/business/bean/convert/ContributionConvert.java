package com.news.hr.business.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.business.bean.po.Contribution;
import com.news.hr.business.bean.form.ContributionForm;
import com.news.hr.business.bean.vo.ContributionVo;
import com.news.hr.business.bean.dto.ContributionImport;
import com.news.hr.business.bean.dto.ContributionExport;
/**
 * <p>
 * ContributionConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class ContributionConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Contribution convertToPoByForm(ContributionForm source){
        Contribution target = new Contribution();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static ContributionVo convertToVoByPo(Contribution source){
        ContributionVo target = new ContributionVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<ContributionVo> convertToVoByPo(List<Contribution> sources){
        List<ContributionVo> contributions = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return contributions;
        }
        for (Contribution source : sources) {
            ContributionVo target = new ContributionVo();
            BeanUtils.copyProperties(source, target);
            contributions.add(target);
        }
        return contributions;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Contribution> convertToPoByImport(List<ContributionImport> sources){
        List<Contribution> contributions = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return contributions;
        }
        for (ContributionImport source : sources) {
            Contribution target = new Contribution();
            BeanUtils.copyProperties(source, target);
            contributions.add(target);
        }
        return contributions;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<ContributionExport> convertToExportByPo(List<Contribution> sources){
        List<ContributionExport> contributionExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return contributionExports;
        }
        for (Contribution source : sources) {
            ContributionExport target = new ContributionExport();
            BeanUtils.copyProperties(source, target);
            contributionExports.add(target);
        }
        return contributionExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<ContributionExport> convertToExportByVo(List<ContributionVo> sources){
        List<ContributionExport> contributionExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return contributionExports;
        }
        for (ContributionVo source : sources) {
            ContributionExport target = new ContributionExport();
            BeanUtils.copyProperties(source, target);
            contributionExports.add(target);
        }
        return contributionExports;
    }

}