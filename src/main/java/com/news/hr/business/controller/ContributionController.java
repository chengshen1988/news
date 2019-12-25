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
import com.news.hr.business.service.ContributionService;
import com.news.hr.business.bean.po.Contribution;
import com.news.hr.business.bean.form.ContributionForm;
import com.news.hr.business.bean.vo.ContributionVo;
import com.news.hr.business.bean.query.ContributionQuery;
import com.news.hr.business.bean.dto.ContributionImport;
import com.news.hr.business.bean.dto.ContributionExport;
import com.news.hr.business.bean.convert.ContributionConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@RestController
@Api(value = "business-Contribution", tags = {"business-Contribution"})
@RequestMapping("contribution")
public class ContributionController {

    
    @Resource
    private ContributionService contributionService;

    /**
    * 保存单条
    * @param contributionForm 保存参数
    * @return com.news.hr.framework.model.ReturnModel 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到Contribution",httpMethod = "POST")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody ContributionForm contributionForm) {
        Integer result = contributionService.save(contributionForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 删除(根据主键id删除)
     * @param contributionId 主键id
     * @return com.news.hr.framework.model.ReturnModel 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除Contribution数据",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteById/contributionId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@ApiParam(name = "contributionId",value = "contribution主键id")
            @PathVariable String contributionId) {
        Integer result = contributionService.deleteById(contributionId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param contributionForm 修改参数
    * @return com.news.hr.framework.model.ReturnModel 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新Contribution数据",httpMethod = "PUT")
    @PutMapping(value = "/updateById/contributionId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody ContributionForm contributionForm) {
        Integer result = contributionService.updateById(contributionForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param contributionId 主键id
    * @return com.news.hr.framework.model.ReturnModel 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取Contribution数据",httpMethod = "GET")
    @GetMapping(value = "/selectById/contributionId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(value = "contributionId")  String contributionId) {
        ContributionVo result = contributionService.selectById(contributionId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param contributionQuery 查询条件
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "分页获取所有contribution信息", notes = "获取所有contribution信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(ContributionQuery contributionQuery){
        IPage<ContributionVo> pageList=contributionService.selectPage(contributionQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     */
    @ApiOperation(value = "下载导入模板",httpMethod = "GET")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<ContributionImport> contributionImports = new ArrayList<>();
        ExcelKit.$Export(ContributionImport.class, response).downXlsx(contributionImports, true);
    }

    /**
     * 导入数据
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "导入数据",httpMethod = "POST")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<ContributionImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(ContributionImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<ContributionImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, ContributionImport entity) {
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

        List<Contribution> contributions = ContributionConvert.convertToPoByImport(successResult);
        contributionService.saveBatch(contributions);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     */
    @ApiOperation(value = "导出信息" , httpMethod = "GET")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, ContributionQuery contributionQuery) {
        List<ContributionVo> contributionVos = contributionService.selectList(contributionQuery);

        List<ContributionExport> contributionExports = ContributionConvert.convertToExportByVo(contributionVos);
        ExcelKit.$Export(ContributionExport.class, response).downXlsx(contributionExports, false);
    }

}
