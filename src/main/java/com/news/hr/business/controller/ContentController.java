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
import com.news.hr.business.service.ContentService;
import com.news.hr.business.bean.po.Content;
import com.news.hr.business.bean.form.ContentForm;
import com.news.hr.business.bean.vo.ContentVo;
import com.news.hr.business.bean.query.ContentQuery;
import com.news.hr.business.bean.dto.ContentImport;
import com.news.hr.business.bean.dto.ContentExport;
import com.news.hr.business.bean.convert.ContentConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@RestController
@Api(value = "business-Content", tags = {"business-Content"})
@RequestMapping("content")
public class ContentController {

    
    @Resource
    private ContentService contentService;

    /**
    * 保存单条
    * @param contentForm 保存参数
    * @return com.news.hr.framework.model.ReturnModel 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到Content",httpMethod = "POST")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody ContentForm contentForm) {
        Integer result = contentService.save(contentForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 删除(根据主键id删除)
     * @param contentId 主键id
     * @return com.news.hr.framework.model.ReturnModel 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除Content数据",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteById/contentId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@ApiParam(name = "contentId",value = "content主键id")
            @PathVariable String contentId) {
        Integer result = contentService.deleteById(contentId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param contentForm 修改参数
    * @return com.news.hr.framework.model.ReturnModel 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新Content数据",httpMethod = "PUT")
    @PutMapping(value = "/updateById/contentId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody ContentForm contentForm) {
        Integer result = contentService.updateById(contentForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param contentId 主键id
    * @return com.news.hr.framework.model.ReturnModel 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取Content数据",httpMethod = "GET")
    @GetMapping(value = "/selectById/contentId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(value = "contentId")  String contentId) {
        ContentVo result = contentService.selectById(contentId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param contentQuery 查询条件
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "分页获取所有content信息", notes = "获取所有content信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(ContentQuery contentQuery){
        IPage<ContentVo> pageList=contentService.selectPage(contentQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     */
    @ApiOperation(value = "下载导入模板",httpMethod = "GET")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<ContentImport> contentImports = new ArrayList<>();
        ExcelKit.$Export(ContentImport.class, response).downXlsx(contentImports, true);
    }

    /**
     * 导入数据
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "导入数据",httpMethod = "POST")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<ContentImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(ContentImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<ContentImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, ContentImport entity) {
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

        List<Content> contents = ContentConvert.convertToPoByImport(successResult);
        contentService.saveBatch(contents);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     */
    @ApiOperation(value = "导出信息" , httpMethod = "GET")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, ContentQuery contentQuery) {
        List<ContentVo> contentVos = contentService.selectList(contentQuery);

        List<ContentExport> contentExports = ContentConvert.convertToExportByVo(contentVos);
        ExcelKit.$Export(ContentExport.class, response).downXlsx(contentExports, false);
    }

}
