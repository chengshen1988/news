package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Dict;
import com.news.hr.system.bean.form.DictForm;
import com.news.hr.system.bean.vo.DictVo;
import com.news.hr.system.bean.dto.DictImport;
import com.news.hr.system.bean.dto.DictExport;
/**
 * <p>
 * DictConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class DictConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Dict convertToPoByForm(DictForm source){
        Dict target = new Dict();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static DictVo convertToVoByPo(Dict source){
        DictVo target = new DictVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<DictVo> convertToVoByPo(List<Dict> sources){
        List<DictVo> dicts = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return dicts;
        }
        for (Dict source : sources) {
            DictVo target = new DictVo();
            BeanUtils.copyProperties(source, target);
            dicts.add(target);
        }
        return dicts;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Dict> convertToPoByImport(List<DictImport> sources){
        List<Dict> dicts = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return dicts;
        }
        for (DictImport source : sources) {
            Dict target = new Dict();
            BeanUtils.copyProperties(source, target);
            dicts.add(target);
        }
        return dicts;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<DictExport> convertToExportByPo(List<Dict> sources){
        List<DictExport> dictExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return dictExports;
        }
        for (Dict source : sources) {
            DictExport target = new DictExport();
            BeanUtils.copyProperties(source, target);
            dictExports.add(target);
        }
        return dictExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<DictExport> convertToExportByVo(List<DictVo> sources){
        List<DictExport> dictExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return dictExports;
        }
        for (DictVo source : sources) {
            DictExport target = new DictExport();
            BeanUtils.copyProperties(source, target);
            dictExports.add(target);
        }
        return dictExports;
    }

}