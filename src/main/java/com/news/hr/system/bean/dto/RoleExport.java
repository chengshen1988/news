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
 * RoleExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Role对象", description="角色")
@Excel("Role导出")
public class RoleExport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "角色Id")
    @ExcelField(value = "角色Id", width=150)
    private String roleId;

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

    @ApiModelProperty(value = "机构编码")
    @ExcelField(value = "机构编码", width=150)
    private String orgCode;

    @ApiModelProperty(value = "角色名称")
    @ExcelField(value = "角色名称", width=150)
    private String roleName;

    @ApiModelProperty(value = "角色编码")
    @ExcelField(value = "角色编码", width=150)
    private String roleCode;

    @ApiModelProperty(value = "角色类型")
    @ExcelField(value = "角色类型", width=150)
    private String roleKind;

    @ApiModelProperty(value = "备注")
    @ExcelField(value = "备注", width=150)
    private String roleComment;



}