package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.LogInfo;
import com.news.hr.system.bean.form.LogInfoForm;
import com.news.hr.system.bean.vo.LogInfoVo;
import com.news.hr.system.bean.dto.LogInfoImport;
import com.news.hr.system.bean.dto.LogInfoExport;
/**
 * <p>
 * LogInfoConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class LogInfoConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static LogInfo convertToPoByForm(LogInfoForm source){
        LogInfo target = new LogInfo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static LogInfoVo convertToVoByPo(LogInfo source){
        LogInfoVo target = new LogInfoVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<LogInfoVo> convertToVoByPo(List<LogInfo> sources){
        List<LogInfoVo> logInfos = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return logInfos;
        }
        for (LogInfo source : sources) {
            LogInfoVo target = new LogInfoVo();
            BeanUtils.copyProperties(source, target);
            logInfos.add(target);
        }
        return logInfos;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<LogInfo> convertToPoByImport(List<LogInfoImport> sources){
        List<LogInfo> logInfos = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return logInfos;
        }
        for (LogInfoImport source : sources) {
            LogInfo target = new LogInfo();
            BeanUtils.copyProperties(source, target);
            logInfos.add(target);
        }
        return logInfos;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<LogInfoExport> convertToExportByPo(List<LogInfo> sources){
        List<LogInfoExport> logInfoExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return logInfoExports;
        }
        for (LogInfo source : sources) {
            LogInfoExport target = new LogInfoExport();
            BeanUtils.copyProperties(source, target);
            logInfoExports.add(target);
        }
        return logInfoExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<LogInfoExport> convertToExportByVo(List<LogInfoVo> sources){
        List<LogInfoExport> logInfoExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return logInfoExports;
        }
        for (LogInfoVo source : sources) {
            LogInfoExport target = new LogInfoExport();
            BeanUtils.copyProperties(source, target);
            logInfoExports.add(target);
        }
        return logInfoExports;
    }

}