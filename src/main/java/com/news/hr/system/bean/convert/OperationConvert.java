package com.news.hr.system.bean.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.news.hr.system.bean.po.Operation;
import com.news.hr.system.bean.form.OperationForm;
import com.news.hr.system.bean.vo.OperationVo;
import com.news.hr.system.bean.dto.OperationImport;
import com.news.hr.system.bean.dto.OperationExport;
/**
 * <p>
 * OperationConvert工具类
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */

public class OperationConvert{
    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static Operation convertToPoByForm(OperationForm source){
        Operation target = new Operation();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Form -> Po
    * @param source 对象
    * @return Do对象
    */
    public static OperationVo convertToVoByPo(Operation source){
        OperationVo target = new OperationVo();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
    * Do -> VO
    * @param sources 对象
    * @return VO对象
    */
    public static  List<OperationVo> convertToVoByPo(List<Operation> sources){
        List<OperationVo> operations = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return operations;
        }
        for (Operation source : sources) {
            OperationVo target = new OperationVo();
            BeanUtils.copyProperties(source, target);
            operations.add(target);
        }
        return operations;
    }

    /**
    * Import -> Po
    * @param sources 对象
    * @return Po对象
    */
    public static  List<Operation> convertToPoByImport(List<OperationImport> sources){
        List<Operation> operations = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return operations;
        }
        for (OperationImport source : sources) {
            Operation target = new Operation();
            BeanUtils.copyProperties(source, target);
            operations.add(target);
        }
        return operations;
    }

    /**
    * Po -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<OperationExport> convertToExportByPo(List<Operation> sources){
        List<OperationExport> operationExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return operationExports;
        }
        for (Operation source : sources) {
            OperationExport target = new OperationExport();
            BeanUtils.copyProperties(source, target);
            operationExports.add(target);
        }
        return operationExports;
    }

    /**
    * Vo -> Export
    * @param sources 对象
    * @return Export对象
    */
    public static  List<OperationExport> convertToExportByVo(List<OperationVo> sources){
        List<OperationExport> operationExports = new ArrayList<>();
        if (CollectionUtils.isEmpty(sources)) {
            return operationExports;
        }
        for (OperationVo source : sources) {
            OperationExport target = new OperationExport();
            BeanUtils.copyProperties(source, target);
            operationExports.add(target);
        }
        return operationExports;
    }

}