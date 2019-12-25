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
import com.news.hr.business.service.NewsInfoService;
import com.news.hr.business.bean.po.NewsInfo;
import com.news.hr.business.bean.form.NewsInfoForm;
import com.news.hr.business.bean.vo.NewsInfoVo;
import com.news.hr.business.bean.query.NewsInfoQuery;
import com.news.hr.business.bean.dto.NewsInfoImport;
import com.news.hr.business.bean.dto.NewsInfoExport;
import com.news.hr.business.bean.convert.NewsInfoConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@RestController
@Api(value = "business-NewsInfo", tags = {"business-NewsInfo"})
@RequestMapping("newsInfo")
public class NewsInfoController {

    
    @Resource
    private NewsInfoService newsInfoService;

    /**
    * 保存单条
    * @param newsInfoForm 保存参数
    * @return com.news.hr.framework.model.ReturnModel 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到NewsInfo",httpMethod = "POST")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody NewsInfoForm newsInfoForm) {
        Integer result = newsInfoService.save(newsInfoForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 删除(根据主键id删除)
     * @param newsInfoId 主键id
     * @return com.news.hr.framework.model.ReturnModel 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除NewsInfo数据",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteById/newsInfoId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@ApiParam(name = "newsInfoId",value = "newsInfo主键id")
            @PathVariable String newsInfoId) {
        Integer result = newsInfoService.deleteById(newsInfoId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param newsInfoForm 修改参数
    * @return com.news.hr.framework.model.ReturnModel 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新NewsInfo数据",httpMethod = "PUT")
    @PutMapping(value = "/updateById/newsInfoId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody NewsInfoForm newsInfoForm) {
        Integer result = newsInfoService.updateById(newsInfoForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param newsInfoId 主键id
    * @return com.news.hr.framework.model.ReturnModel 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取NewsInfo数据",httpMethod = "GET")
    @GetMapping(value = "/selectById/newsInfoId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(value = "newsInfoId")  String newsInfoId) {
        NewsInfoVo result = newsInfoService.selectById(newsInfoId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param newsInfoQuery 查询条件
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "分页获取所有newsInfo信息", notes = "获取所有newsInfo信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(NewsInfoQuery newsInfoQuery){
        IPage<NewsInfoVo> pageList=newsInfoService.selectPage(newsInfoQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     */
    @ApiOperation(value = "下载导入模板",httpMethod = "GET")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<NewsInfoImport> newsInfoImports = new ArrayList<>();
        ExcelKit.$Export(NewsInfoImport.class, response).downXlsx(newsInfoImports, true);
    }

    /**
     * 导入数据
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "导入数据",httpMethod = "POST")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<NewsInfoImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(NewsInfoImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<NewsInfoImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, NewsInfoImport entity) {
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

        List<NewsInfo> newsInfos = NewsInfoConvert.convertToPoByImport(successResult);
        newsInfoService.saveBatch(newsInfos);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     */
    @ApiOperation(value = "导出信息" , httpMethod = "GET")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, NewsInfoQuery newsInfoQuery) {
        List<NewsInfoVo> newsInfoVos = newsInfoService.selectList(newsInfoQuery);

        List<NewsInfoExport> newsInfoExports = NewsInfoConvert.convertToExportByVo(newsInfoVos);
        ExcelKit.$Export(NewsInfoExport.class, response).downXlsx(newsInfoExports, false);
    }

}
