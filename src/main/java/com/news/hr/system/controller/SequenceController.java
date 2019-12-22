package com.news.hr.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.collections4.CollectionUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import com.news.hr.framework.poi.ExcelKit;
import com.news.hr.framework.poi.pojo.ExcelErrorField;
import com.news.hr.framework.poi.handler.ExcelReadHandler;
import com.news.hr.framework.model.ReturnModel;
import com.news.hr.framework.model.Code;
import com.news.hr.system.service.SequenceService;
import com.news.hr.system.bean.po.Sequence;
import com.news.hr.system.bean.form.SequenceForm;
import com.news.hr.system.bean.vo.SequenceVo;
import com.news.hr.system.bean.query.SequenceQuery;
import com.news.hr.system.bean.dto.SequenceImport;
import com.news.hr.system.bean.dto.SequenceExport;
import com.news.hr.system.bean.convert.SequenceConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@RestController
@Api(value = "system-Sequence", tags = {"system-Sequence"})
@RequestMapping("sequence")
public class SequenceController {

    
    @Resource
    private SequenceService sequenceService;

    /**
    * 保存单条
    * @param sequenceForm 保存参数
    * @return com.news.hr.framework.model.ReturnModel 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到Sequence",httpMethod = "POST")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody SequenceForm sequenceForm) {
        Integer result = sequenceService.save(sequenceForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 删除(根据主键id删除)
     * @param sequenceId 主键id
     * @return com.news.hr.framework.model.ReturnModel 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除Sequence数据",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteById/sequenceId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@ApiParam(name = "sequenceId",value = "sequence主键id")
            @PathVariable String sequenceId) {
        Integer result = sequenceService.deleteById(sequenceId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param sequenceForm 修改参数
    * @return com.news.hr.framework.model.ReturnModel 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新Sequence数据",httpMethod = "PUT")
    @PutMapping(value = "/updateById/sequenceId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody SequenceForm sequenceForm) {
        Integer result = sequenceService.updateById(sequenceForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param sequenceId 主键id
    * @return com.news.hr.framework.model.ReturnModel 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取Sequence数据",httpMethod = "GET")
    @GetMapping(value = "/selectById/sequenceId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(value = "sequenceId")  String sequenceId) {
        SequenceVo result = sequenceService.selectById(sequenceId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param sequenceQuery 查询条件
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "分页获取所有sequence信息", notes = "获取所有sequence信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(SequenceQuery sequenceQuery){
        IPage<SequenceVo> pageList=sequenceService.selectPage(sequenceQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     */
    @ApiOperation(value = "下载导入模板",httpMethod = "GET")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<SequenceImport> sequenceImports = new ArrayList<>();
        ExcelKit.$Export(SequenceImport.class, response).downXlsx(sequenceImports, true);
    }

    /**
     * 导入数据
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "导入数据",httpMethod = "POST")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<SequenceImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(SequenceImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<SequenceImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, SequenceImport entity) {
                successResult.add(entity); // 单行读取成功，加入入库队列。
            }

            @Override
            public void onError(int sheetIndex, int rowIndex, List<ExcelErrorField> errorFields) {
                errorResult.add(ImmutableMap.of("sheetIndex", sheetIndex, "rowIndex", rowIndex, "errorFields", errorFields));
            }
        });
        if (CollectionUtils.isNotEmpty(errorResult)) {
            return ReturnModel.newFailureInstance(Code.$1501_DATA_CHECK_ERROR, errorResult, "导入文件失败");
        }

        List<Sequence> sequences = SequenceConvert.convertToPoByImport(successResult);
        sequenceService.saveBatch(sequences);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     */
    @ApiOperation(value = "导出信息" , httpMethod = "GET")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, SequenceQuery sequenceQuery) {
        List<SequenceVo> sequenceVos = sequenceService.selectList(sequenceQuery);

        List<SequenceExport> sequenceExports = SequenceConvert.convertToExportByVo(sequenceVos);
        ExcelKit.$Export(SequenceExport.class, response).downXlsx(sequenceExports, false);
    }

    /*******************通用方法结束**********************/
}
