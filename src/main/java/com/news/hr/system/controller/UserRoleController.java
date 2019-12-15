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
import com.news.hr.system.service.UserRoleService;
import com.news.hr.system.bean.po.UserRole;
import com.news.hr.system.bean.form.UserRoleForm;
import com.news.hr.system.bean.vo.UserRoleVo;
import com.news.hr.system.bean.query.UserRoleQuery;
import com.news.hr.system.bean.dto.UserRoleImport;
import com.news.hr.system.bean.dto.UserRoleExport;
import com.news.hr.system.bean.convert.UserRoleConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@RestController
@Api(value = "system-UserRole", tags = {"system-UserRole"})
@RequestMapping("userRole")
public class UserRoleController {

    private final Logger logger=LoggerFactory.getLogger(UserRoleController.class);
    @Resource
    private UserRoleService userRoleService;

    /**
    * 保存单条
    * @param userRoleForm 保存参数
    * @return 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到UserRole")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody UserRoleForm userRoleForm) {
        Integer result = userRoleService.save(userRoleForm);
        return ReturnModel.newSuccessInstance(userRoleForm);
    }

    /**
     * 删除(根据主键id删除)
     * @param userRoleId 主键id
     * @return 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除UserRole数据")
    @PostMapping(value = "/deleteById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@RequestParam(required = true, value = "userRoleId") String userRoleId) {
        Integer result = userRoleService.deleteById(userRoleId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param userRoleForm 修改参数
    * @return 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新UserRole数据")
    @PostMapping(value = "/updateById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody UserRoleForm userRoleForm) {
        Integer result = userRoleService.updateById(userRoleForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param userRoleId 主键id
    * @return 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取UserRole数据")
    @GetMapping(value = "/selectById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(required = true, value = "userRoleId") String userRoleId) {
        UserRoleVo result = userRoleService.selectById(userRoleId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param userRoleQuery 查询条件
     * @return
     */
    @ApiOperation(value = "分页获取所有userRole信息", notes = "获取所有userRole信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(UserRoleQuery userRoleQuery){
        IPage<UserRoleVo> pageList=userRoleService.selectPage(userRoleQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     * @return
     */
    @ApiOperation("下载导入模板")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<UserRoleImport> userRoleImports = new ArrayList<>();
        ExcelKit.$Export(UserRoleImport.class, response).downXlsx(userRoleImports, true);
    }

    /**
     * 导入数据
     * @return
     */
    @ApiOperation("导入数据")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
        List<UserRoleImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(UserRoleImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<UserRoleImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, UserRoleImport entity) {
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

        List<UserRole> userRoles = UserRoleConvert.convertToPoByImport(successResult);
        userRoleService.saveBatch(userRoles);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     * @return
     */
    @ApiOperation("导出信息")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, UserRoleQuery userRoleQuery) {
        List<UserRoleVo> userRoleVos = userRoleService.selectList(userRoleQuery);

        List<UserRoleExport> userRoleExports = UserRoleConvert.convertToExportByVo(userRoleVos);
        ExcelKit.$Export(UserRoleExport.class, response).downXlsx(userRoleExports, false);
    }

    /*******************通用方法结束**********************/
}
