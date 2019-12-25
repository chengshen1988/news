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
import com.news.hr.business.service.LinkManageService;
import com.news.hr.business.bean.po.LinkManage;
import com.news.hr.business.bean.form.LinkManageForm;
import com.news.hr.business.bean.vo.LinkManageVo;
import com.news.hr.business.bean.query.LinkManageQuery;
import com.news.hr.business.bean.dto.LinkManageImport;
import com.news.hr.business.bean.dto.LinkManageExport;
import com.news.hr.business.bean.convert.LinkManageConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@RestController
@Api(value = "business-LinkManage", tags = {"business-LinkManage"})
@RequestMapping("linkManage")
public class LinkManageController {

    
    @Resource
    private LinkManageService linkManageService;

    /**
    * 保存单条
    * @param linkManageForm 保存参数
    * @return com.news.hr.framework.model.ReturnModel 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到LinkManage",httpMethod = "POST")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody LinkManageForm linkManageForm) {
        Integer result = linkManageService.save(linkManageForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 删除(根据主键id删除)
     * @param linkManageId 主键id
     * @return com.news.hr.framework.model.ReturnModel 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除LinkManage数据",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteById/linkManageId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@ApiParam(name = "linkManageId",value = "linkManage主键id")
            @PathVariable String linkManageId) {
        Integer result = linkManageService.deleteById(linkManageId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param linkManageForm 修改参数
    * @return com.news.hr.framework.model.ReturnModel 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新LinkManage数据",httpMethod = "PUT")
    @PutMapping(value = "/updateById/linkManageId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody LinkManageForm linkManageForm) {
        Integer result = linkManageService.updateById(linkManageForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param linkManageId 主键id
    * @return com.news.hr.framework.model.ReturnModel 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取LinkManage数据",httpMethod = "GET")
    @GetMapping(value = "/selectById/linkManageId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(value = "linkManageId")  String linkManageId) {
        LinkManageVo result = linkManageService.selectById(linkManageId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param linkManageQuery 查询条件
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "分页获取所有linkManage信息", notes = "获取所有linkManage信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(LinkManageQuery linkManageQuery){
        IPage<LinkManageVo> pageList=linkManageService.selectPage(linkManageQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     */
    @ApiOperation(value = "下载导入模板",httpMethod = "GET")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<LinkManageImport> linkManageImports = new ArrayList<>();
        ExcelKit.$Export(LinkManageImport.class, response).downXlsx(linkManageImports, true);
    }

    /**
     * 导入数据
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "导入数据",httpMethod = "POST")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<LinkManageImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(LinkManageImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<LinkManageImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, LinkManageImport entity) {
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

        List<LinkManage> linkManages = LinkManageConvert.convertToPoByImport(successResult);
        linkManageService.saveBatch(linkManages);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     */
    @ApiOperation(value = "导出信息" , httpMethod = "GET")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, LinkManageQuery linkManageQuery) {
        List<LinkManageVo> linkManageVos = linkManageService.selectList(linkManageQuery);

        List<LinkManageExport> linkManageExports = LinkManageConvert.convertToExportByVo(linkManageVos);
        ExcelKit.$Export(LinkManageExport.class, response).downXlsx(linkManageExports, false);
    }

}
