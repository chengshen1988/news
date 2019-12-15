package com.news.hr.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
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
import com.news.hr.system.service.RegionService;
import com.news.hr.system.bean.po.Region;
import com.news.hr.system.bean.form.RegionForm;
import com.news.hr.system.bean.vo.RegionVo;
import com.news.hr.system.bean.query.RegionQuery;
import com.news.hr.system.bean.dto.RegionImport;
import com.news.hr.system.bean.dto.RegionExport;
import com.news.hr.system.bean.convert.RegionConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@RestController
@Api(value = "system-Region", tags = {"system-Region"})
@RequestMapping("region")
public class RegionController {

    private final Logger logger=LoggerFactory.getLogger(RegionController.class);
    @Resource
    private RegionService regionService;

    /**
    * 保存单条
    * @param regionForm 保存参数
    * @return 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到Region")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody RegionForm regionForm) {
        Integer result = regionService.save(regionForm);
        return ReturnModel.newSuccessInstance(regionForm);
    }

    /**
     * 删除(根据主键id删除)
     * @param regionId 主键id
     * @return 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除Region数据")
    @PostMapping(value = "/deleteById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@RequestParam(required = true, value = "regionId") String regionId) {
        Integer result = regionService.deleteById(regionId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param regionForm 修改参数
    * @return 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新Region数据")
    @PostMapping(value = "/updateById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody RegionForm regionForm) {
        Integer result = regionService.updateById(regionForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param regionId 主键id
    * @return 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取Region数据")
    @GetMapping(value = "/selectById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(required = true, value = "regionId") String regionId) {
        RegionVo result = regionService.selectById(regionId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param regionQuery 查询条件
     * @return
     */
    @ApiOperation(value = "分页获取所有region信息", notes = "获取所有region信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(RegionQuery regionQuery){
        IPage<RegionVo> pageList=regionService.selectPage(regionQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     * @return
     */
    @ApiOperation("下载导入模板")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<RegionImport> regionImports = new ArrayList<>();
        ExcelKit.$Export(RegionImport.class, response).downXlsx(regionImports, true);
    }

    /**
     * 导入数据
     * @return
     */
    @ApiOperation("导入数据")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
        List<RegionImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(RegionImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<RegionImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, RegionImport entity) {
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

        List<Region> regions = RegionConvert.convertToPoByImport(successResult);
        regionService.saveBatch(regions);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     * @return
     */
    @ApiOperation("导出信息")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, RegionQuery regionQuery) {
        List<RegionVo> regionVos = regionService.selectList(regionQuery);

        List<RegionExport> regionExports = RegionConvert.convertToExportByVo(regionVos);
        ExcelKit.$Export(RegionExport.class, response).downXlsx(regionExports, false);
    }

    /*******************通用方法结束**********************/
}
