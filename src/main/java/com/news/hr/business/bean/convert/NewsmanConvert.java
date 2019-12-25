package com.news.hr.business.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.business.bean.po.Newsman;
import com.news.hr.business.bean.form.NewsmanForm;
import com.news.hr.business.bean.vo.NewsmanVo;
import com.news.hr.business.bean.dto.NewsmanImport;
import com.news.hr.business.bean.dto.NewsmanExport;
/**
 * <p>
 * NewsmanConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class NewsmanConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Newsman convertToPoByForm(NewsmanForm source){
        Newsman target = new Newsman();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static NewsmanVo convertToVoByPo(Newsman source){
        NewsmanVo target = new NewsmanVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<NewsmanVo> convertToVoByPo(List<Newsman> sources){
        List<NewsmanVo> newsmans = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsmans;
        }
        for (Newsman source : sources) {
            NewsmanVo target = new NewsmanVo();
            BeanUtils.copyProperties(source, target);
            newsmans.add(target);
        }
        return newsmans;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Newsman> convertToPoByImport(List<NewsmanImport> sources){
        List<Newsman> newsmans = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsmans;
        }
        for (NewsmanImport source : sources) {
            Newsman target = new Newsman();
            BeanUtils.copyProperties(source, target);
            newsmans.add(target);
        }
        return newsmans;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<NewsmanExport> convertToExportByPo(List<Newsman> sources){
        List<NewsmanExport> newsmanExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsmanExports;
        }
        for (Newsman source : sources) {
            NewsmanExport target = new NewsmanExport();
            BeanUtils.copyProperties(source, target);
            newsmanExports.add(target);
        }
        return newsmanExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<NewsmanExport> convertToExportByVo(List<NewsmanVo> sources){
        List<NewsmanExport> newsmanExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsmanExports;
        }
        for (NewsmanVo source : sources) {
            NewsmanExport target = new NewsmanExport();
            BeanUtils.copyProperties(source, target);
            newsmanExports.add(target);
        }
        return newsmanExports;
    }

}