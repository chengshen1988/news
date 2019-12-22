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
 * MenuImport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Menu对象", description="菜单")
@Excel("Menu导入")
public class MenuImport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "菜单Id")
    @ExcelField(value = "菜单Id", required = true, comment = "请填写菜单Id", width=150)
    private String menuId;

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
    private String menuParent;

    @ApiModelProperty(value = "菜单路径")
    @ExcelField(value = "菜单路径", required = true, comment = "请填写菜单路径", width=150)
    private String menuPath;

    @ApiModelProperty(value = "级别")
    @ExcelField(value = "级别", required = true, comment = "请填写级别", width=150)
    private Integer menuLevel;

    @ExcelField(value = "XXX", required = true, comment = "请填写", width=150)
    private String isLeaf;

    @ApiModelProperty(value = "菜单类型")
    @ExcelField(value = "菜单类型", required = true, comment = "请填写菜单类型", width=150)
    private String menuKind;

    @ApiModelProperty(value = "菜单名称")
    @ExcelField(value = "菜单名称", required = true, comment = "请填写菜单名称", width=150)
    private String menuName;

    @ApiModelProperty(value = "菜单别名")
    @ExcelField(value = "菜单别名", required = true, comment = "请填写菜单别名", width=150)
    private String menuNameAlias;

    @ApiModelProperty(value = "菜单编码")
    @ExcelField(value = "菜单编码", required = true, comment = "请填写菜单编码", width=150)
    private String menuCode;

    @ApiModelProperty(value = "菜单业务")
    @ExcelField(value = "菜单业务", required = true, comment = "请填写菜单业务", width=150)
    private String menuModule;

    @ApiModelProperty(value = "菜单Url")
    @ExcelField(value = "菜单Url", required = true, comment = "请填写菜单Url", width=150)
    private String menuModuleUrl;

    @ApiModelProperty(value = "菜单权限配置（具体对应类似于shiro permission）")
    @ExcelField(value = "菜单权限配置（具体对应类似于shiro permission）", required = true, comment = "请填写菜单权限配置（具体对应类似于shiro permission）", width=150)
    private String menuAuth;

    @ExcelField(value = "XXX", required = true, comment = "请填写", width=150)
    private String menuIconCls;

    @ExcelField(value = "XXX", required = true, comment = "请填写", width=150)
    private String menuComment;



}