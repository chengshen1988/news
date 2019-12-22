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
import com.news.hr.system.service.AccessLogService;
import com.news.hr.system.bean.po.AccessLog;
import com.news.hr.system.bean.form.AccessLogForm;
import com.news.hr.system.bean.vo.AccessLogVo;
import com.news.hr.system.bean.query.AccessLogQuery;
import com.news.hr.system.bean.dto.AccessLogImport;
import com.news.hr.system.bean.dto.AccessLogExport;
import com.news.hr.system.bean.convert.AccessLogConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@RestController
@Api(value = "system-AccessLog", tags = {"system-AccessLog"})
@RequestMapping("accessLog")
public class AccessLogController {

    
    @Resource
    private AccessLogService accessLogService;

    /**
    * 保存单条
    * @param accessLogForm 保存参数
    * @return com.news.hr.framework.model.ReturnModel 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到AccessLog",httpMethod = "POST")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody AccessLogForm accessLogForm) {
        Integer result = accessLogService.save(accessLogForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 删除(根据主键id删除)
     * @param accessLogId 主键id
     * @return com.news.hr.framework.model.ReturnModel 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除AccessLog数据",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteById/accessLogId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@ApiParam(name = "accessLogId",value = "accessLog主键id")
            @PathVariable String accessLogId) {
        Integer result = accessLogService.deleteById(accessLogId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param accessLogForm 修改参数
    * @return com.news.hr.framework.model.ReturnModel 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新AccessLog数据",httpMethod = "PUT")
    @PutMapping(value = "/updateById/accessLogId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody AccessLogForm accessLogForm) {
        Integer result = accessLogService.updateById(accessLogForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param accessLogId 主键id
    * @return com.news.hr.framework.model.ReturnModel 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取AccessLog数据",httpMethod = "GET")
    @GetMapping(value = "/selectById/accessLogId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(value = "accessLogId")  String accessLogId) {
        AccessLogVo result = accessLogService.selectById(accessLogId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param accessLogQuery 查询条件
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "分页获取所有accessLog信息", notes = "获取所有accessLog信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(AccessLogQuery accessLogQuery){
        IPage<AccessLogVo> pageList=accessLogService.selectPage(accessLogQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     */
    @ApiOperation(value = "下载导入模板",httpMethod = "GET")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<AccessLogImport> accessLogImports = new ArrayList<>();
        ExcelKit.$Export(AccessLogImport.class, response).downXlsx(accessLogImports, true);
    }

    /**
     * 导入数据
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "导入数据",httpMethod = "POST")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<AccessLogImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(AccessLogImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<AccessLogImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, AccessLogImport entity) {
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

        List<AccessLog> accessLogs = AccessLogConvert.convertToPoByImport(successResult);
        accessLogService.saveBatch(accessLogs);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     */
    @ApiOperation(value = "导出信息" , httpMethod = "GET")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, AccessLogQuery accessLogQuery) {
        List<AccessLogVo> accessLogVos = accessLogService.selectList(accessLogQuery);

        List<AccessLogExport> accessLogExports = AccessLogConvert.convertToExportByVo(accessLogVos);
        ExcelKit.$Export(AccessLogExport.class, response).downXlsx(accessLogExports, false);
    }

    /*******************通用方法结束**********************/
}
