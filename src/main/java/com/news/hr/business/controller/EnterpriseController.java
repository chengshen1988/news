package com.news.hr.business.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;

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
import com.news.hr.business.service.EnterpriseService;
import com.news.hr.business.bean.po.Enterprise;
import com.news.hr.business.bean.form.EnterpriseForm;
import com.news.hr.business.bean.vo.EnterpriseVo;
import com.news.hr.business.bean.query.EnterpriseQuery;
import com.news.hr.business.bean.dto.EnterpriseImport;
import com.news.hr.business.bean.dto.EnterpriseExport;
import com.news.hr.business.bean.convert.EnterpriseConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@RestController
@Api(value = "business-Enterprise", tags = {"business-Enterprise"})
@RequestMapping("enterprise")
public class EnterpriseController {

    
    @Resource
    private EnterpriseService enterpriseService;

    /**
    * 保存单条
    * @param enterpriseForm 保存参数
    * @return com.news.hr.framework.model.ReturnModel 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到Enterprise",httpMethod = "POST")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody EnterpriseForm enterpriseForm) {
        Integer result = enterpriseService.save(enterpriseForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 删除(根据主键id删除)
     * @param enterpriseId 主键id
     * @return com.news.hr.framework.model.ReturnModel 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除Enterprise数据",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteById/enterpriseId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@ApiParam(name = "enterpriseId",value = "enterprise主键id")
            @PathVariable String enterpriseId) {
        Integer result = enterpriseService.deleteById(enterpriseId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param enterpriseForm 修改参数
    * @return com.news.hr.framework.model.ReturnModel 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新Enterprise数据",httpMethod = "PUT")
    @PutMapping(value = "/updateById/enterpriseId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody EnterpriseForm enterpriseForm) {
        Integer result = enterpriseService.updateById(enterpriseForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param enterpriseId 主键id
    * @return com.news.hr.framework.model.ReturnModel 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取Enterprise数据",httpMethod = "GET")
    @GetMapping(value = "/selectById/enterpriseId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(value = "enterpriseId")  String enterpriseId) {
        EnterpriseVo result = enterpriseService.selectById(enterpriseId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param enterpriseQuery 查询条件
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "分页获取所有enterprise信息", notes = "获取所有enterprise信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(EnterpriseQuery enterpriseQuery){
        IPage<EnterpriseVo> pageList=enterpriseService.selectPage(enterpriseQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     */
    @ApiOperation(value = "下载导入模板",httpMethod = "GET")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<EnterpriseImport> enterpriseImports = new ArrayList<>();
        ExcelKit.$Export(EnterpriseImport.class, response).downXlsx(enterpriseImports, true);
    }

    /**
     * 导入数据
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "导入数据",httpMethod = "POST")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<EnterpriseImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(EnterpriseImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<EnterpriseImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, EnterpriseImport entity) {
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

        List<Enterprise> enterprises = EnterpriseConvert.convertToPoByImport(successResult);
        enterpriseService.saveBatch(enterprises);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     */
    @ApiOperation(value = "导出信息" , httpMethod = "GET")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, EnterpriseQuery enterpriseQuery) {
        List<EnterpriseVo> enterpriseVos = enterpriseService.selectList(enterpriseQuery);

        List<EnterpriseExport> enterpriseExports = EnterpriseConvert.convertToExportByVo(enterpriseVos);
        ExcelKit.$Export(EnterpriseExport.class, response).downXlsx(enterpriseExports, false);
    }

}
