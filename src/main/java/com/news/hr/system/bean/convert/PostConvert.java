package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Post;
import com.news.hr.system.bean.form.PostForm;
import com.news.hr.system.bean.vo.PostVo;
import com.news.hr.system.bean.dto.PostImport;
import com.news.hr.system.bean.dto.PostExport;
/**
 * <p>
 * PostConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class PostConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Post convertToPoByForm(PostForm source){
        Post target = new Post();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static PostVo convertToVoByPo(Post source){
        PostVo target = new PostVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<PostVo> convertToVoByPo(List<Post> sources){
        List<PostVo> posts = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return posts;
        }
        for (Post source : sources) {
            PostVo target = new PostVo();
            BeanUtils.copyProperties(source, target);
            posts.add(target);
        }
        return posts;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Post> convertToPoByImport(List<PostImport> sources){
        List<Post> posts = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return posts;
        }
        for (PostImport source : sources) {
            Post target = new Post();
            BeanUtils.copyProperties(source, target);
            posts.add(target);
        }
        return posts;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<PostExport> convertToExportByPo(List<Post> sources){
        List<PostExport> postExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return postExports;
        }
        for (Post source : sources) {
            PostExport target = new PostExport();
            BeanUtils.copyProperties(source, target);
            postExports.add(target);
        }
        return postExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<PostExport> convertToExportByVo(List<PostVo> sources){
        List<PostExport> postExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return postExports;
        }
        for (PostVo source : sources) {
            PostExport target = new PostExport();
            BeanUtils.copyProperties(source, target);
            postExports.add(target);
        }
        return postExports;
    }

}