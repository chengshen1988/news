package com.news.hr.business.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.business.bean.po.Content;
import com.news.hr.business.bean.form.ContentForm;
import com.news.hr.business.bean.vo.ContentVo;
import com.news.hr.business.bean.dto.ContentImport;
import com.news.hr.business.bean.dto.ContentExport;
/**
 * <p>
 * ContentConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class ContentConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Content convertToPoByForm(ContentForm source){
        Content target = new Content();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static ContentVo convertToVoByPo(Content source){
        ContentVo target = new ContentVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<ContentVo> convertToVoByPo(List<Content> sources){
        List<ContentVo> contents = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return contents;
        }
        for (Content source : sources) {
            ContentVo target = new ContentVo();
            BeanUtils.copyProperties(source, target);
            contents.add(target);
        }
        return contents;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Content> convertToPoByImport(List<ContentImport> sources){
        List<Content> contents = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return contents;
        }
        for (ContentImport source : sources) {
            Content target = new Content();
            BeanUtils.copyProperties(source, target);
            contents.add(target);
        }
        return contents;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<ContentExport> convertToExportByPo(List<Content> sources){
        List<ContentExport> contentExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return contentExports;
        }
        for (Content source : sources) {
            ContentExport target = new ContentExport();
            BeanUtils.copyProperties(source, target);
            contentExports.add(target);
        }
        return contentExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<ContentExport> convertToExportByVo(List<ContentVo> sources){
        List<ContentExport> contentExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return contentExports;
        }
        for (ContentVo source : sources) {
            ContentExport target = new ContentExport();
            BeanUtils.copyProperties(source, target);
            contentExports.add(target);
        }
        return contentExports;
    }

}