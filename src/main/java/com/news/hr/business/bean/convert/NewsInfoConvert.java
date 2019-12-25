package com.news.hr.business.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.business.bean.po.NewsInfo;
import com.news.hr.business.bean.form.NewsInfoForm;
import com.news.hr.business.bean.vo.NewsInfoVo;
import com.news.hr.business.bean.dto.NewsInfoImport;
import com.news.hr.business.bean.dto.NewsInfoExport;
/**
 * <p>
 * NewsInfoConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class NewsInfoConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static NewsInfo convertToPoByForm(NewsInfoForm source){
        NewsInfo target = new NewsInfo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static NewsInfoVo convertToVoByPo(NewsInfo source){
        NewsInfoVo target = new NewsInfoVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<NewsInfoVo> convertToVoByPo(List<NewsInfo> sources){
        List<NewsInfoVo> newsInfos = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsInfos;
        }
        for (NewsInfo source : sources) {
            NewsInfoVo target = new NewsInfoVo();
            BeanUtils.copyProperties(source, target);
            newsInfos.add(target);
        }
        return newsInfos;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<NewsInfo> convertToPoByImport(List<NewsInfoImport> sources){
        List<NewsInfo> newsInfos = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsInfos;
        }
        for (NewsInfoImport source : sources) {
            NewsInfo target = new NewsInfo();
            BeanUtils.copyProperties(source, target);
            newsInfos.add(target);
        }
        return newsInfos;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<NewsInfoExport> convertToExportByPo(List<NewsInfo> sources){
        List<NewsInfoExport> newsInfoExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsInfoExports;
        }
        for (NewsInfo source : sources) {
            NewsInfoExport target = new NewsInfoExport();
            BeanUtils.copyProperties(source, target);
            newsInfoExports.add(target);
        }
        return newsInfoExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<NewsInfoExport> convertToExportByVo(List<NewsInfoVo> sources){
        List<NewsInfoExport> newsInfoExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsInfoExports;
        }
        for (NewsInfoVo source : sources) {
            NewsInfoExport target = new NewsInfoExport();
            BeanUtils.copyProperties(source, target);
            newsInfoExports.add(target);
        }
        return newsInfoExports;
    }

}