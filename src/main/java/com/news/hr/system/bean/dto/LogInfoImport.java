package com.news.hr.system.bean.dto;

import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.news.hr.framework.poi.annotation.Excel;
import com.news.hr.framework.poi.annotation.ExcelField;
/**
 * <p>
 * LogInfoImport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="LogInfo对象", description="系统日志")
@Excel("LogInfo导入")
public class LogInfoImport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "系统日志Id")
    @ExcelField(value = "系统日志Id", required = true, comment = "请填写系统日志Id", width=150)
    private Integer logInfoId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @ExcelField(value = "删除标记（0：正常，1：删除）", required = true, comment = "请填写删除标记（0：正常，1：删除）", width=150)
    private Integer delFlag;

    @ApiModelProperty(value = "创建用户的登录名")
    @ExcelField(value = "创建用户的登录名", required = true, comment = "请填写创建用户的登录名", width=150)
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    @ExcelField(value = "创建用户的名称", required = true, comment = "请填写创建用户的名称", width=150)
    private String cUserName;

    @ApiModelProperty(value = "创建时间")
    @ExcelField(value = "创建时间", required = true, comment = "请填写创建时间", width=150)
    private LocalDateTime ctime;

    @ApiModelProperty(value = "请求的远程IP")
    @ExcelField(value = "请求的远程IP", required = true, comment = "请填写请求的远程IP", width=150)
    private String remoteIp;

    @ApiModelProperty(value = "访问模块")
    @ExcelField(value = "访问模块", required = true, comment = "请填写访问模块", width=150)
    private String module;

    @ApiModelProperty(value = "日志类型")
    @ExcelField(value = "日志类型", required = true, comment = "请填写日志类型", width=150)
    private String logKind;

    @ApiModelProperty(value = "日志消息")
    @ExcelField(value = "日志消息", required = true, comment = "请填写日志消息", width=150)
    private String message;

    @ApiModelProperty(value = "业务数据")
    @ExcelField(value = "业务数据", required = true, comment = "请填写业务数据", width=150)
    private String businessData;



}