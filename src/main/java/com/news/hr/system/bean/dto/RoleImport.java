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
 * RoleImport对象
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
@Excel("Role导入")
public class RoleImport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "角色Id")
    @ExcelField(value = "角色Id", required = true, comment = "请填写角色Id", width=150)
    private String roleId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @ExcelField(value = "删除标记（0：正常，1：删除）", required = true, comment = "请填写删除标记（0：正常，1：删除）", width=150)
    private Integer delFlag;

    @ApiModelProperty(value = "排序字段（用户可以手动操作数据顺序时用到）")
    @ExcelField(value = "排序字段（用户可以手动操作数据顺序时用到）", required = true, comment = "请填写排序字段（用户可以手动操作数据顺序时用到）", width=150)
    private Integer dataOrder;

    @ApiModelProperty(value = "创建用户的登录名")
    @ExcelField(value = "创建用户的登录名", required = true, comment = "请填写创建用户的登录名", width=150)
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    @ExcelField(value = "创建用户的名称", required = true, comment = "请填写创建用户的名称", width=150)
    private String cUserName;

    @ApiModelProperty(value = "创建时间")
    @ExcelField(value = "创建时间", required = true, comment = "请填写创建时间", width=150)
    private LocalDateTime ctime;

    @ApiModelProperty(value = "最后修改的用户的登录名")
    @ExcelField(value = "最后修改的用户的登录名", required = true, comment = "请填写最后修改的用户的登录名", width=150)
    private String mUserId;

    @ApiModelProperty(value = "最后修改的用户的名称")
    @ExcelField(value = "最后修改的用户的名称", required = true, comment = "请填写最后修改的用户的名称", width=150)
    private String mUserName;

    @ApiModelProperty(value = "最后修改时间")
    @ExcelField(value = "最后修改时间", required = true, comment = "请填写最后修改时间", width=150)
    private LocalDateTime mtime;

    @ApiModelProperty(value = "机构编码")
    @ExcelField(value = "机构编码", required = true, comment = "请填写机构编码", width=150)
    private String orgCode;

    @ApiModelProperty(value = "角色名称")
    @ExcelField(value = "角色名称", required = true, comment = "请填写角色名称", width=150)
    private String roleName;

    @ApiModelProperty(value = "角色编码")
    @ExcelField(value = "角色编码", required = true, comment = "请填写角色编码", width=150)
    private String roleCode;

    @ApiModelProperty(value = "角色类型")
    @ExcelField(value = "角色类型", required = true, comment = "请填写角色类型", width=150)
    private String roleKind;

    @ApiModelProperty(value = "备注")
    @ExcelField(value = "备注", required = true, comment = "请填写备注", width=150)
    private String roleComment;



}