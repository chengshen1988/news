package com.news.hr.system.bean.dto;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import com.news.hr.framework.poi.annotation.Excel;
import com.news.hr.framework.poi.annotation.ExcelField;
/**
 * <p>
 * LogExceptionExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="LogException对象", description="系统日志表")
@Excel("LogException导出")
public class LogExceptionExport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "异常Id")
    @ExcelField(value = "异常Id", width=150)
    private Integer logExceptionId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @ExcelField(value = "删除标记（0：正常，1：删除）", width=150)
    private Integer delFlag;

    @ApiModelProperty(value = "创建用户的登录名")
    @ExcelField(value = "创建用户的登录名", width=150)
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    @ExcelField(value = "创建用户的名称", width=150)
    private String cUserName;

    @ApiModelProperty(value = "访问类型")
    @ExcelField(value = "访问类型", width=150)
    private String exceptionName;

    @ApiModelProperty(value = "请求的远程IP")
    @ExcelField(value = "请求的远程IP", width=150)
    private String remoteIp;

    @ApiModelProperty(value = "模块名称")
    @ExcelField(value = "模块名称", width=150)
    private String moduleName;

    @ApiModelProperty(value = "请求地址")
    @ExcelField(value = "请求地址", width=150)
    private String url;

    @ApiModelProperty(value = "请求数据")
    @ExcelField(value = "请求数据", width=150)
    private String data;

    @ApiModelProperty(value = "错误提示")
    @ExcelField(value = "错误提示", width=150)
    private String message;

    @ApiModelProperty(value = "错误信息")
    @ExcelField(value = "错误信息", width=150)
    private String stacktrace;



}