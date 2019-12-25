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
import com.news.hr.business.service.NewsmanService;
import com.news.hr.business.bean.po.Newsman;
import com.news.hr.business.bean.form.NewsmanForm;
import com.news.hr.business.bean.vo.NewsmanVo;
import com.news.hr.business.bean.query.NewsmanQuery;
import com.news.hr.business.bean.dto.NewsmanImport;
import com.news.hr.business.bean.dto.NewsmanExport;
import com.news.hr.business.bean.convert.NewsmanConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@RestController
@Api(value = "business-Newsman", tags = {"business-Newsman"})
@RequestMapping("newsman")
public class NewsmanController {

    
    @Resource
    private NewsmanService newsmanService;

    /**
    * 保存单条
    * @param newsmanForm 保存参数
    * @return com.news.hr.framework.model.ReturnModel 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到Newsman",httpMethod = "POST")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody NewsmanForm newsmanForm) {
        Integer result = newsmanService.save(newsmanForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 删除(根据主键id删除)
     * @param newsmanId 主键id
     * @return com.news.hr.framework.model.ReturnModel 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除Newsman数据",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteById/newsmanId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@ApiParam(name = "newsmanId",value = "newsman主键id")
            @PathVariable String newsmanId) {
        Integer result = newsmanService.deleteById(newsmanId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param newsmanForm 修改参数
    * @return com.news.hr.framework.model.ReturnModel 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新Newsman数据",httpMethod = "PUT")
    @PutMapping(value = "/updateById/newsmanId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody NewsmanForm newsmanForm) {
        Integer result = newsmanService.updateById(newsmanForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param newsmanId 主键id
    * @return com.news.hr.framework.model.ReturnModel 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取Newsman数据",httpMethod = "GET")
    @GetMapping(value = "/selectById/newsmanId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(value = "newsmanId")  String newsmanId) {
        NewsmanVo result = newsmanService.selectById(newsmanId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param newsmanQuery 查询条件
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "分页获取所有newsman信息", notes = "获取所有newsman信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(NewsmanQuery newsmanQuery){
        IPage<NewsmanVo> pageList=newsmanService.selectPage(newsmanQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     */
    @ApiOperation(value = "下载导入模板",httpMethod = "GET")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<NewsmanImport> newsmanImports = new ArrayList<>();
        ExcelKit.$Export(NewsmanImport.class, response).downXlsx(newsmanImports, true);
    }

    /**
     * 导入数据
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "导入数据",httpMethod = "POST")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<NewsmanImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(NewsmanImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<NewsmanImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, NewsmanImport entity) {
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

        List<Newsman> newsmans = NewsmanConvert.convertToPoByImport(successResult);
        newsmanService.saveBatch(newsmans);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     */
    @ApiOperation(value = "导出信息" , httpMethod = "GET")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, NewsmanQuery newsmanQuery) {
        List<NewsmanVo> newsmanVos = newsmanService.selectList(newsmanQuery);

        List<NewsmanExport> newsmanExports = NewsmanConvert.convertToExportByVo(newsmanVos);
        ExcelKit.$Export(NewsmanExport.class, response).downXlsx(newsmanExports, false);
    }

}
