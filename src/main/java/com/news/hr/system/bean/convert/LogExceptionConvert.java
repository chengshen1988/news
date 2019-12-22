package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.LogException;
import com.news.hr.system.bean.form.LogExceptionForm;
import com.news.hr.system.bean.vo.LogExceptionVo;
import com.news.hr.system.bean.dto.LogExceptionImport;
import com.news.hr.system.bean.dto.LogExceptionExport;
/**
 * <p>
 * LogExceptionConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class LogExceptionConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static LogException convertToPoByForm(LogExceptionForm source){
        LogException target = new LogException();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static LogExceptionVo convertToVoByPo(LogException source){
        LogExceptionVo target = new LogExceptionVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<LogExceptionVo> convertToVoByPo(List<LogException> sources){
        List<LogExceptionVo> logExceptions = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return logExceptions;
        }
        for (LogException source : sources) {
            LogExceptionVo target = new LogExceptionVo();
            BeanUtils.copyProperties(source, target);
            logExceptions.add(target);
        }
        return logExceptions;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<LogException> convertToPoByImport(List<LogExceptionImport> sources){
        List<LogException> logExceptions = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return logExceptions;
        }
        for (LogExceptionImport source : sources) {
            LogException target = new LogException();
            BeanUtils.copyProperties(source, target);
            logExceptions.add(target);
        }
        return logExceptions;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<LogExceptionExport> convertToExportByPo(List<LogException> sources){
        List<LogExceptionExport> logExceptionExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return logExceptionExports;
        }
        for (LogException source : sources) {
            LogExceptionExport target = new LogExceptionExport();
            BeanUtils.copyProperties(source, target);
            logExceptionExports.add(target);
        }
        return logExceptionExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<LogExceptionExport> convertToExportByVo(List<LogExceptionVo> sources){
        List<LogExceptionExport> logExceptionExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return logExceptionExports;
        }
        for (LogExceptionVo source : sources) {
            LogExceptionExport target = new LogExceptionExport();
            BeanUtils.copyProperties(source, target);
            logExceptionExports.add(target);
        }
        return logExceptionExports;
    }

}