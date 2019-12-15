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
 * AccessLogImport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="AccessLog对象", description="访问日志")
@Excel("AccessLog导入")
public class AccessLogImport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "访问日志Id")
    @ExcelField(value = "访问日志Id", required = true, comment = "请填写访问日志Id", width=150)
    private Integer accessLogId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @ExcelField(value = "删除标记（0：正常，1：删除）", required = true, comment = "请填写删除标记（0：正常，1：删除）", width=150)
    private Integer delFlag;

    @ApiModelProperty(value = "创建用户的登录名")
    @ExcelField(value = "创建用户的登录名", required = true, comment = "请填写创建用户的登录名", width=150)
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    @ExcelField(value = "创建用户的名称", required = true, comment = "请填写创建用户的名称", width=150)
    private String cUserName;

    @ApiModelProperty(value = "访问类型")
    @ExcelField(value = "访问类型", required = true, comment = "请填写访问类型", width=150)
    private String accessKind;

    @ApiModelProperty(value = "请求的远程IP")
    @ExcelField(value = "请求的远程IP", required = true, comment = "请填写请求的远程IP", width=150)
    private String remoteIp;

    @ApiModelProperty(value = "访问模块")
    @ExcelField(value = "访问模块", required = true, comment = "请填写访问模块", width=150)
    private String moduleId;

    @ApiModelProperty(value = "模块名称")
    @ExcelField(value = "模块名称", required = true, comment = "请填写模块名称", width=150)
    private String moduleName;

    @ApiModelProperty(value = "请求地址")
    @ExcelField(value = "请求地址", required = true, comment = "请填写请求地址", width=150)
    private String url;

    @ApiModelProperty(value = "备注")
    @ExcelField(value = "备注", required = true, comment = "请填写备注", width=150)
    private String dataComment;



}