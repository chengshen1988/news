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
import com.news.hr.business.service.LevelService;
import com.news.hr.business.bean.po.Level;
import com.news.hr.business.bean.form.LevelForm;
import com.news.hr.business.bean.vo.LevelVo;
import com.news.hr.business.bean.query.LevelQuery;
import com.news.hr.business.bean.dto.LevelImport;
import com.news.hr.business.bean.dto.LevelExport;
import com.news.hr.business.bean.convert.LevelConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@RestController
@Api(value = "business-Level", tags = {"business-Level"})
@RequestMapping("level")
public class LevelController {

    
    @Resource
    private LevelService levelService;

    /**
    * 保存单条
    * @param levelForm 保存参数
    * @return com.news.hr.framework.model.ReturnModel 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到Level",httpMethod = "POST")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody LevelForm levelForm) {
        Integer result = levelService.save(levelForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 删除(根据主键id删除)
     * @param levelId 主键id
     * @return com.news.hr.framework.model.ReturnModel 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除Level数据",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteById/levelId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@ApiParam(name = "levelId",value = "level主键id")
            @PathVariable String levelId) {
        Integer result = levelService.deleteById(levelId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param levelForm 修改参数
    * @return com.news.hr.framework.model.ReturnModel 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新Level数据",httpMethod = "PUT")
    @PutMapping(value = "/updateById/levelId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody LevelForm levelForm) {
        Integer result = levelService.updateById(levelForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param levelId 主键id
    * @return com.news.hr.framework.model.ReturnModel 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取Level数据",httpMethod = "GET")
    @GetMapping(value = "/selectById/levelId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(value = "levelId")  String levelId) {
        LevelVo result = levelService.selectById(levelId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param levelQuery 查询条件
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "分页获取所有level信息", notes = "获取所有level信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(LevelQuery levelQuery){
        IPage<LevelVo> pageList=levelService.selectPage(levelQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     */
    @ApiOperation(value = "下载导入模板",httpMethod = "GET")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<LevelImport> levelImports = new ArrayList<>();
        ExcelKit.$Export(LevelImport.class, response).downXlsx(levelImports, true);
    }

    /**
     * 导入数据
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "导入数据",httpMethod = "POST")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<LevelImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(LevelImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<LevelImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, LevelImport entity) {
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

        List<Level> levels = LevelConvert.convertToPoByImport(successResult);
        levelService.saveBatch(levels);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     */
    @ApiOperation(value = "导出信息" , httpMethod = "GET")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, LevelQuery levelQuery) {
        List<LevelVo> levelVos = levelService.selectList(levelQuery);

        List<LevelExport> levelExports = LevelConvert.convertToExportByVo(levelVos);
        ExcelKit.$Export(LevelExport.class, response).downXlsx(levelExports, false);
    }

}
