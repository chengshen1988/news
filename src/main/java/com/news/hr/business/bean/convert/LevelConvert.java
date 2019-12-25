package com.news.hr.business.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.business.bean.po.Level;
import com.news.hr.business.bean.form.LevelForm;
import com.news.hr.business.bean.vo.LevelVo;
import com.news.hr.business.bean.dto.LevelImport;
import com.news.hr.business.bean.dto.LevelExport;
/**
 * <p>
 * LevelConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class LevelConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Level convertToPoByForm(LevelForm source){
        Level target = new Level();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static LevelVo convertToVoByPo(Level source){
        LevelVo target = new LevelVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<LevelVo> convertToVoByPo(List<Level> sources){
        List<LevelVo> levels = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return levels;
        }
        for (Level source : sources) {
            LevelVo target = new LevelVo();
            BeanUtils.copyProperties(source, target);
            levels.add(target);
        }
        return levels;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Level> convertToPoByImport(List<LevelImport> sources){
        List<Level> levels = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return levels;
        }
        for (LevelImport source : sources) {
            Level target = new Level();
            BeanUtils.copyProperties(source, target);
            levels.add(target);
        }
        return levels;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<LevelExport> convertToExportByPo(List<Level> sources){
        List<LevelExport> levelExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return levelExports;
        }
        for (Level source : sources) {
            LevelExport target = new LevelExport();
            BeanUtils.copyProperties(source, target);
            levelExports.add(target);
        }
        return levelExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<LevelExport> convertToExportByVo(List<LevelVo> sources){
        List<LevelExport> levelExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return levelExports;
        }
        for (LevelVo source : sources) {
            LevelExport target = new LevelExport();
            BeanUtils.copyProperties(source, target);
            levelExports.add(target);
        }
        return levelExports;
    }

}