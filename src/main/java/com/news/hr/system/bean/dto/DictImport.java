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
 * DictImport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Dict对象", description="数据字典")
@Excel("Dict导入")
public class DictImport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "数据字典Id")
    @ExcelField(value = "数据字典Id", required = true, comment = "请填写数据字典Id", width=150)
    private String dictId;

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

    @ApiModelProperty(value = "父级Id")
    @ExcelField(value = "父级Id", required = true, comment = "请填写父级Id", width=150)
    private String dictParent;

    @ApiModelProperty(value = "路径")
    @ExcelField(value = "路径", required = true, comment = "请填写路径", width=150)
    private String dictPath;

    @ApiModelProperty(value = "级别")
    @ExcelField(value = "级别", required = true, comment = "请填写级别", width=150)
    private Integer dictLevel;

    @ApiModelProperty(value = "是否叶子节电")
    @ExcelField(value = "是否叶子节电", required = true, comment = "请填写是否叶子节电", width=150)
    private Integer isLeaf;

    @ApiModelProperty(value = "类型（分类、值）")
    @ExcelField(value = "类型（分类、值）", required = true, comment = "请填写类型（分类、值）", width=150)
    private String dictKind;

    @ApiModelProperty(value = "显示值")
    @ExcelField(value = "显示值", required = true, comment = "请填写显示值", width=150)
    private String dictDisplay;

    @ApiModelProperty(value = "实际值")
    @ExcelField(value = "实际值", required = true, comment = "请填写实际值", width=150)
    private String dictValue;

    @ApiModelProperty(value = "备注")
    @ExcelField(value = "备注", required = true, comment = "请填写备注", width=150)
    private String dictComment;



}