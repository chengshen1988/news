package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.File;
import com.news.hr.system.bean.form.FileForm;
import com.news.hr.system.bean.vo.FileVo;
import com.news.hr.system.bean.dto.FileImport;
import com.news.hr.system.bean.dto.FileExport;
/**
 * <p>
 * FileConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class FileConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static File convertToPoByForm(FileForm source){
        File target = new File();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static FileVo convertToVoByPo(File source){
        FileVo target = new FileVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<FileVo> convertToVoByPo(List<File> sources){
        List<FileVo> files = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return files;
        }
        for (File source : sources) {
            FileVo target = new FileVo();
            BeanUtils.copyProperties(source, target);
            files.add(target);
        }
        return files;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<File> convertToPoByImport(List<FileImport> sources){
        List<File> files = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return files;
        }
        for (FileImport source : sources) {
            File target = new File();
            BeanUtils.copyProperties(source, target);
            files.add(target);
        }
        return files;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<FileExport> convertToExportByPo(List<File> sources){
        List<FileExport> fileExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return fileExports;
        }
        for (File source : sources) {
            FileExport target = new FileExport();
            BeanUtils.copyProperties(source, target);
            fileExports.add(target);
        }
        return fileExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<FileExport> convertToExportByVo(List<FileVo> sources){
        List<FileExport> fileExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return fileExports;
        }
        for (FileVo source : sources) {
            FileExport target = new FileExport();
            BeanUtils.copyProperties(source, target);
            fileExports.add(target);
        }
        return fileExports;
    }

}