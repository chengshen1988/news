package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Region;
import com.news.hr.system.bean.form.RegionForm;
import com.news.hr.system.bean.vo.RegionVo;
import com.news.hr.system.bean.dto.RegionImport;
import com.news.hr.system.bean.dto.RegionExport;
/**
 * <p>
 * RegionConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class RegionConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Region convertToPoByForm(RegionForm source){
        Region target = new Region();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static RegionVo convertToVoByPo(Region source){
        RegionVo target = new RegionVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<RegionVo> convertToVoByPo(List<Region> sources){
        List<RegionVo> regions = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return regions;
        }
        for (Region source : sources) {
            RegionVo target = new RegionVo();
            BeanUtils.copyProperties(source, target);
            regions.add(target);
        }
        return regions;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Region> convertToPoByImport(List<RegionImport> sources){
        List<Region> regions = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return regions;
        }
        for (RegionImport source : sources) {
            Region target = new Region();
            BeanUtils.copyProperties(source, target);
            regions.add(target);
        }
        return regions;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<RegionExport> convertToExportByPo(List<Region> sources){
        List<RegionExport> regionExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return regionExports;
        }
        for (Region source : sources) {
            RegionExport target = new RegionExport();
            BeanUtils.copyProperties(source, target);
            regionExports.add(target);
        }
        return regionExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<RegionExport> convertToExportByVo(List<RegionVo> sources){
        List<RegionExport> regionExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return regionExports;
        }
        for (RegionVo source : sources) {
            RegionExport target = new RegionExport();
            BeanUtils.copyProperties(source, target);
            regionExports.add(target);
        }
        return regionExports;
    }

}