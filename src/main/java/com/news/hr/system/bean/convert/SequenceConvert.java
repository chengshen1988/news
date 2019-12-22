package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Sequence;
import com.news.hr.system.bean.form.SequenceForm;
import com.news.hr.system.bean.vo.SequenceVo;
import com.news.hr.system.bean.dto.SequenceImport;
import com.news.hr.system.bean.dto.SequenceExport;
/**
 * <p>
 * SequenceConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class SequenceConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Sequence convertToPoByForm(SequenceForm source){
        Sequence target = new Sequence();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static SequenceVo convertToVoByPo(Sequence source){
        SequenceVo target = new SequenceVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<SequenceVo> convertToVoByPo(List<Sequence> sources){
        List<SequenceVo> sequences = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return sequences;
        }
        for (Sequence source : sources) {
            SequenceVo target = new SequenceVo();
            BeanUtils.copyProperties(source, target);
            sequences.add(target);
        }
        return sequences;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Sequence> convertToPoByImport(List<SequenceImport> sources){
        List<Sequence> sequences = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return sequences;
        }
        for (SequenceImport source : sources) {
            Sequence target = new Sequence();
            BeanUtils.copyProperties(source, target);
            sequences.add(target);
        }
        return sequences;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<SequenceExport> convertToExportByPo(List<Sequence> sources){
        List<SequenceExport> sequenceExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return sequenceExports;
        }
        for (Sequence source : sources) {
            SequenceExport target = new SequenceExport();
            BeanUtils.copyProperties(source, target);
            sequenceExports.add(target);
        }
        return sequenceExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<SequenceExport> convertToExportByVo(List<SequenceVo> sources){
        List<SequenceExport> sequenceExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return sequenceExports;
        }
        for (SequenceVo source : sources) {
            SequenceExport target = new SequenceExport();
            BeanUtils.copyProperties(source, target);
            sequenceExports.add(target);
        }
        return sequenceExports;
    }

}