package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.AccessLog;
import com.news.hr.system.bean.form.AccessLogForm;
import com.news.hr.system.bean.vo.AccessLogVo;
import com.news.hr.system.bean.dto.AccessLogImport;
import com.news.hr.system.bean.dto.AccessLogExport;
/**
 * <p>
 * AccessLogConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */

public class AccessLogConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static AccessLog convertToPoByForm(AccessLogForm source){
        AccessLog target = new AccessLog();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static AccessLogVo convertToVoByPo(AccessLog source){
        AccessLogVo target = new AccessLogVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<AccessLogVo> convertToVoByPo(List<AccessLog> sources){
        List<AccessLogVo> accessLogs = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return accessLogs;
        }
        for (AccessLog source : sources) {
            AccessLogVo target = new AccessLogVo();
            BeanUtils.copyProperties(source, target);
            accessLogs.add(target);
        }
        return accessLogs;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<AccessLog> convertToPoByImport(List<AccessLogImport> sources){
        List<AccessLog> accessLogs = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return accessLogs;
        }
        for (AccessLogImport source : sources) {
            AccessLog target = new AccessLog();
            BeanUtils.copyProperties(source, target);
            accessLogs.add(target);
        }
        return accessLogs;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<AccessLogExport> convertToExportByPo(List<AccessLog> sources){
        List<AccessLogExport> accessLogExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return accessLogExports;
        }
        for (AccessLog source : sources) {
            AccessLogExport target = new AccessLogExport();
            BeanUtils.copyProperties(source, target);
            accessLogExports.add(target);
        }
        return accessLogExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<AccessLogExport> convertToExportByVo(List<AccessLogVo> sources){
        List<AccessLogExport> accessLogExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return accessLogExports;
        }
        for (AccessLogVo source : sources) {
            AccessLogExport target = new AccessLogExport();
            BeanUtils.copyProperties(source, target);
            accessLogExports.add(target);
        }
        return accessLogExports;
    }

}