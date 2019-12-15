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
 * GroupExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Group对象", description="用户组")
@Excel("Group导出")
public class GroupExport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "用户组Id")
    @ExcelField(value = "用户组Id", width=150)
    private String groupId;

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

    @ApiModelProperty(value = "所属组织机构编码")
    @ExcelField(value = "所属组织机构编码", width=150)
    private String orgCode;

    @ApiModelProperty(value = "用户组名称")
    @ExcelField(value = "用户组名称", width=150)
    private String groupName;

    @ApiModelProperty(value = "用户组编码")
    @ExcelField(value = "用户组编码", width=150)
    private String groupCode;

    @ApiModelProperty(value = "备注")
    @ExcelField(value = "备注", width=150)
    private String dataComment;



}