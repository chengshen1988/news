package com.news.hr.system.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
/**
 * <p>
 * Menu对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
@ApiModel(value = "Menu对象", description = "菜单")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "菜单Id")
    @TableId(value = "menu_id", type = IdType.UUID)
        private String menuId;

        @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @TableField("del_flag")
    private Integer delFlag;

        @ApiModelProperty(value = "排序字段（用户可以手动操作数据顺序时用到）")
    @TableField("data_order")
    private Integer dataOrder;

        @ApiModelProperty(value = "创建用户的登录名")
    @TableField("c_user_id")
    private String cUserId;

        @ApiModelProperty(value = "创建用户的名称")
    @TableField("c_user_name")
    private String cUserName;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "创建时间")
    @TableField(value = "ctime", fill = FieldFill.INSERT)
    private LocalDateTime ctime;

        @ApiModelProperty(value = "最后修改的用户的登录名")
    @TableField("m_user_id")
    private String mUserId;

        @ApiModelProperty(value = "最后修改的用户的名称")
    @TableField("m_user_name")
    private String mUserName;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "最后修改时间")
    @TableField(value = "mtime", fill = FieldFill.UPDATE)
    private LocalDateTime mtime;

        @ApiModelProperty(value = "父级Id")
    @TableField("menu_parent")
    private String menuParent;

        @ApiModelProperty(value = "菜单路径")
    @TableField("menu_path")
    private String menuPath;

        @ApiModelProperty(value = "级别")
    @TableField("menu_level")
    private Integer menuLevel;

    @TableField("is_leaf")
    private String isLeaf;

        @ApiModelProperty(value = "菜单类型")
    @TableField("menu_kind")
    private String menuKind;

        @ApiModelProperty(value = "菜单名称")
    @TableField("menu_name")
    private String menuName;

        @ApiModelProperty(value = "菜单别名")
    @TableField("menu_name_alias")
    private String menuNameAlias;

        @ApiModelProperty(value = "菜单编码")
    @TableField("menu_code")
    private String menuCode;

        @ApiModelProperty(value = "菜单业务")
    @TableField("menu_module")
    private String menuModule;

        @ApiModelProperty(value = "菜单Url")
    @TableField("menu_module_url")
    private String menuModuleUrl;

        @ApiModelProperty(value = "菜单权限配置（具体对应类似于shiro permission）")
    @TableField("menu_auth")
    private String menuAuth;

    @TableField("menu_icon_cls")
    private String menuIconCls;

    @TableField("menu_comment")
    private String menuComment;


    @Override
    protected Serializable pkVal(){
            return this.menuId;
        }

}