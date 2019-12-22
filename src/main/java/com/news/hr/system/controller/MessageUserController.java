package com.news.hr.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.*;
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
import com.news.hr.system.service.MessageUserService;
import com.news.hr.system.bean.po.MessageUser;
import com.news.hr.system.bean.form.MessageUserForm;
import com.news.hr.system.bean.vo.MessageUserVo;
import com.news.hr.system.bean.query.MessageUserQuery;
import com.news.hr.system.bean.dto.MessageUserImport;
import com.news.hr.system.bean.dto.MessageUserExport;
import com.news.hr.system.bean.convert.MessageUserConvert;

/**
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@RestController
@Api(value = "system-MessageUser", tags = {"system-MessageUser"})
@RequestMapping("messageUser")
public class MessageUserController {

    
    @Resource
    private MessageUserService messageUserService;

    /**
    * 保存单条
    * @param messageUserForm 保存参数
    * @return com.news.hr.framework.model.ReturnModel 是否添加成功
    */
    @ApiOperation(value = "保存数据", notes = "保存数据到MessageUser",httpMethod = "POST")
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel save(@RequestBody MessageUserForm messageUserForm) {
        Integer result = messageUserService.save(messageUserForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 删除(根据主键id删除)
     * @param messageUserId 主键id
     * @return com.news.hr.framework.model.ReturnModel 是否删除成功
     */
    @ApiOperation(value = "删除数据", notes = "根据主键id删除MessageUser数据",httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteById/messageUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel deleteById(@ApiParam(name = "messageUserId",value = "messageUser主键id")
            @PathVariable String messageUserId) {
        Integer result = messageUserService.deleteById(messageUserId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 更新(根据主键id更新)
    * @param messageUserForm 修改参数
    * @return com.news.hr.framework.model.ReturnModel 是否更改成功
    */
    @ApiOperation(value = "更新数据", notes = "根据主键id更新MessageUser数据",httpMethod = "PUT")
    @PutMapping(value = "/updateById/messageUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel updateById(@RequestBody MessageUserForm messageUserForm) {
        Integer result = messageUserService.updateById(messageUserForm);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
    * 根据主键id查询单条
    * @param messageUserId 主键id
    * @return com.news.hr.framework.model.ReturnModel 查询结果
    */
    @ApiOperation(value = "获取单条数据", notes = "根据主键id获取MessageUser数据",httpMethod = "GET")
    @GetMapping(value = "/selectById/messageUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectById(@RequestParam(value = "messageUserId")  String messageUserId) {
        MessageUserVo result = messageUserService.selectById(messageUserId);
        return ReturnModel.newSuccessInstance(result);
    }

    /**
     * 分页查询数据
     * @param messageUserQuery 查询条件
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "分页获取所有messageUser信息", notes = "获取所有messageUser信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码(page)", example = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "limit", value = "每页展示条数(limit)", example = "10", dataType = "int", required = true)
    })
    @GetMapping(value = "/selectPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReturnModel selectPage(MessageUserQuery messageUserQuery){
        IPage<MessageUserVo> pageList=messageUserService.selectPage(messageUserQuery);
        return ReturnModel.newSuccessInstance(pageList);
    }

    /**
     * 下载导入模板
     */
    @ApiOperation(value = "下载导入模板",httpMethod = "GET")
    @GetMapping(value = "downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        List<MessageUserImport> messageUserImports = new ArrayList<>();
        ExcelKit.$Export(MessageUserImport.class, response).downXlsx(messageUserImports, true);
    }

    /**
     * 导入数据
     * @return com.news.hr.framework.model.ReturnModel
     */
    @ApiOperation(value = "导入数据",httpMethod = "POST")
    @PostMapping(value = "importData")
    public ReturnModel importData(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<MessageUserImport> successResult = Lists.newArrayList();
        List<Map<String, Object>> errorResult = Lists.newArrayList();
        ExcelKit.$Import(MessageUserImport.class).readXlsx(file.getInputStream(), new ExcelReadHandler<MessageUserImport>() {
            @Override
            public void onSuccess(int sheetIndex, int rowIndex, MessageUserImport entity) {
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

        List<MessageUser> messageUsers = MessageUserConvert.convertToPoByImport(successResult);
        messageUserService.saveBatch(messageUsers);
        return ReturnModel.newSuccessInstance(1);
    }

    /**
     * 导出数据
     */
    @ApiOperation(value = "导出信息" , httpMethod = "GET")
    @GetMapping(value = "exportData")
    public void exportData(HttpServletResponse response, MessageUserQuery messageUserQuery) {
        List<MessageUserVo> messageUserVos = messageUserService.selectList(messageUserQuery);

        List<MessageUserExport> messageUserExports = MessageUserConvert.convertToExportByVo(messageUserVos);
        ExcelKit.$Export(MessageUserExport.class, response).downXlsx(messageUserExports, false);
    }

    /*******************通用方法结束**********************/
}
