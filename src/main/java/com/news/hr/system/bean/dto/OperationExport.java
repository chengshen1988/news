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
 * OperationExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Operation对象", description="系统操作")
@Excel("Operation导出")
public class OperationExport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "操作Id")
    @ExcelField(value = "操作Id", width=150)
    private String operationId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @ExcelField(value = "删除标记（0：正常，1：删除）", width=150)
    private Integer delFlag;

    @ApiModelProperty(value = "排序字段（用户可以手动操作数据顺序时用到）")
    @ExcelField(value = "排序字段（用户可以手动操作数据顺序时用到）", width=150)
    private Integer dataOrder;

    @ApiModelProperty(value = "创建用户的登录名")
    @ExcelField(value = "创建用户的登录名", width=150)
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    @ExcelField(value = "创建用户的名称", width=150)
    private String cUserName;

    @ApiModelProperty(value = "创建时间")
    @ExcelField(value = "创建时间", width=150)
    private LocalDateTime ctime;

    @ApiModelProperty(value = "最后修改的用户的登录名")
    @ExcelField(value = "最后修改的用户的登录名", width=150)
    private String mUserId;

    @ApiModelProperty(value = "最后修改的用户的名称")
    @ExcelField(value = "最后修改的用户的名称", width=150)
    private String mUserName;

    @ApiModelProperty(value = "最后修改时间")
    @ExcelField(value = "最后修改时间", width=150)
    private LocalDateTime mtime;

    @ApiModelProperty(value = "菜单Id")
    @ExcelField(value = "菜单Id", width=150)
    private String menuId;

    @ApiModelProperty(value = "操作类型")
    @ExcelField(value = "操作类型", width=150)
    private String operationKind;

    @ApiModelProperty(value = "操作名称")
    @ExcelField(value = "操作名称", width=150)
    private String operationName;

    @ApiModelProperty(value = "操作编码")
    @ExcelField(value = "操作编码", width=150)
    private String operationCode;

    @ApiModelProperty(value = "页面标识")
    @ExcelField(value = "页面标识", width=150)
    private String pageKey;

    @ApiModelProperty(value = "操作权限")
    @ExcelField(value = "操作权限", width=150)
    private String operationAuth;

    @ApiModelProperty(value = "备注")
    @ExcelField(value = "备注", width=150)
    private String operationComment;



}