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
 * PermissionImport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Permission对象", description="权限表")
@Excel("Permission导入")
public class PermissionImport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "权限id")
    @ExcelField(value = "权限id", required = true, comment = "请填写权限id", width=150)
    private Integer permissionId;

    @ApiModelProperty(value = "权限类型（菜单、操作、数据）")
    @ExcelField(value = "权限类型（菜单、操作、数据）", required = true, comment = "请填写权限类型（菜单、操作、数据）", width=150)
    private String permissionKind;

    @ApiModelProperty(value = "角色id")
    @ExcelField(value = "角色id", required = true, comment = "请填写角色id", width=150)
    private String roleId;

    @ApiModelProperty(value = "资源id")
    @ExcelField(value = "资源id", required = true, comment = "请填写资源id", width=150)
    private String resourceId;

    @ApiModelProperty(value = "资源标识")
    @ExcelField(value = "资源标识", required = true, comment = "请填写资源标识", width=150)
    private String resourceKey;

    @ApiModelProperty(value = "资源名称")
    @ExcelField(value = "资源名称", required = true, comment = "请填写资源名称", width=150)
    private String resourceName;

    @ApiModelProperty(value = "资源权限")
    @ExcelField(value = "资源权限", required = true, comment = "请填写资源权限", width=150)
    private String resourceAuth;

    @ApiModelProperty(value = "公式")
    @ExcelField(value = "公式", required = true, comment = "请填写公式", width=150)
    private String formula;

    @ApiModelProperty(value = "资源值")
    @ExcelField(value = "资源值", required = true, comment = "请填写资源值", width=150)
    private String resourceValue;

    @ApiModelProperty(value = "备注")
    @ExcelField(value = "备注", required = true, comment = "请填写备注", width=150)
    private String dataComment;



}