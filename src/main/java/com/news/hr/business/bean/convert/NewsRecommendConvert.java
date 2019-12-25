package com.news.hr.business.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.business.bean.po.NewsRecommend;
import com.news.hr.business.bean.form.NewsRecommendForm;
import com.news.hr.business.bean.vo.NewsRecommendVo;
import com.news.hr.business.bean.dto.NewsRecommendImport;
import com.news.hr.business.bean.dto.NewsRecommendExport;
/**
 * <p>
 * NewsRecommendConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class NewsRecommendConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static NewsRecommend convertToPoByForm(NewsRecommendForm source){
        NewsRecommend target = new NewsRecommend();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static NewsRecommendVo convertToVoByPo(NewsRecommend source){
        NewsRecommendVo target = new NewsRecommendVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<NewsRecommendVo> convertToVoByPo(List<NewsRecommend> sources){
        List<NewsRecommendVo> newsRecommends = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsRecommends;
        }
        for (NewsRecommend source : sources) {
            NewsRecommendVo target = new NewsRecommendVo();
            BeanUtils.copyProperties(source, target);
            newsRecommends.add(target);
        }
        return newsRecommends;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<NewsRecommend> convertToPoByImport(List<NewsRecommendImport> sources){
        List<NewsRecommend> newsRecommends = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsRecommends;
        }
        for (NewsRecommendImport source : sources) {
            NewsRecommend target = new NewsRecommend();
            BeanUtils.copyProperties(source, target);
            newsRecommends.add(target);
        }
        return newsRecommends;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<NewsRecommendExport> convertToExportByPo(List<NewsRecommend> sources){
        List<NewsRecommendExport> newsRecommendExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsRecommendExports;
        }
        for (NewsRecommend source : sources) {
            NewsRecommendExport target = new NewsRecommendExport();
            BeanUtils.copyProperties(source, target);
            newsRecommendExports.add(target);
        }
        return newsRecommendExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<NewsRecommendExport> convertToExportByVo(List<NewsRecommendVo> sources){
        List<NewsRecommendExport> newsRecommendExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return newsRecommendExports;
        }
        for (NewsRecommendVo source : sources) {
            NewsRecommendExport target = new NewsRecommendExport();
            BeanUtils.copyProperties(source, target);
            newsRecommendExports.add(target);
        }
        return newsRecommendExports;
    }

}