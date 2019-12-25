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
import com.news.hr.business.service.NewsRecommendService;
import com.news.hr.business.bean.po.NewsRecommend;
import com.news.hr.business.bean.form.NewsRecommendForm;
import com.news.hr.business.bean.vo.NewsRecommendVo;
import com.news.hr.business.bean.query.NewsRecommendQuery;
import com.news.hr.business.bean.dto.NewsRecommendImport;
import com.news.hr.business.bean.dto.NewsRecommendExport;
import com.news.hr.business.bean.convert.NewsRecommendConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@RestController
@Api(value = "business-NewsRecommend", tags = {"business-NewsRecommend"})
@RequestMapping("newsRecommend")
public class NewsRecommendController {

    
    @Resource
    private NewsRecommendService newsRecommendService;

    /**
    * 保存单条
    * @param newsRecommendForm 保存参数
    * @return com.news.hr.framework.model.ReturnModel 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到NewsRecommend",httpMethod = "POST")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody NewsRecommendForm newsRecommendForm) {
        Integer result = newsRecommendService.save(newsRecommendForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 删除(根据主键id删除)
     * @param newsRecommendId 主键id
     * @return com.news.hr.framework.model.ReturnModel 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除NewsRecommend数据",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteById/newsRecommendId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@ApiParam(name = "newsRecommendId",value = "newsRecommend主键id")
            @PathVariable String newsRecommendId) {
        Integer result = newsRecommendService.deleteById(newsRecommendId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param newsRecommendForm 修改参数
    * @return com.news.hr.framework.model.ReturnModel 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新NewsRecommend数据",httpMethod = "PUT")
    @PutMapping(value = "/updateById/newsRecommendId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody NewsRecommendForm newsRecommendForm) {
        Integer result = newsRecommendService.updateById(newsRecommendForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param newsRecommendId 主键id
    * @return com.news.hr.framework.model.ReturnModel 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取NewsRecommend数据",httpMethod = "GET")
    @GetMapping(value = "/selectById/newsRecommendId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(value = "newsRecommendId")  String newsRecommendId) {
        NewsRecommendVo result = newsRecommendService.selectById(newsRecommendId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param newsRecommendQuery 查询条件
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "分页获取所有newsRecommend信息", notes = "获取所有newsRecommend信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(NewsRecommendQuery newsRecommendQuery){
        IPage<NewsRecommendVo> pageList=newsRecommendService.selectPage(newsRecommendQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     */
    @ApiOperation(value = "下载导入模板",httpMethod = "GET")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<NewsRecommendImport> newsRecommendImports = new ArrayList<>();
        ExcelKit.$Export(NewsRecommendImport.class, response).downXlsx(newsRecommendImports, true);
    }

    /**
     * 导入数据
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "导入数据",httpMethod = "POST")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<NewsRecommendImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(NewsRecommendImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<NewsRecommendImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, NewsRecommendImport entity) {
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

        List<NewsRecommend> newsRecommends = NewsRecommendConvert.convertToPoByImport(successResult);
        newsRecommendService.saveBatch(newsRecommends);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     */
    @ApiOperation(value = "导出信息" , httpMethod = "GET")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, NewsRecommendQuery newsRecommendQuery) {
        List<NewsRecommendVo> newsRecommendVos = newsRecommendService.selectList(newsRecommendQuery);

        List<NewsRecommendExport> newsRecommendExports = NewsRecommendConvert.convertToExportByVo(newsRecommendVos);
        ExcelKit.$Export(NewsRecommendExport.class, response).downXlsx(newsRecommendExports, false);
    }

}
