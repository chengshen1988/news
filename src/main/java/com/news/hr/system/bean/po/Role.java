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
 * Role对象
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
@TableName("sys_role")
@ApiModel(value = "Role对象", description = "角色")
public class Role extends Model<Role> {

    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "角色Id")
    @TableId(value = "role_id", type = IdType.UUID)
        private String roleId;

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

        @ApiModelProperty(value = "机构编码")
    @TableField("org_code")
    private String orgCode;

        @ApiModelProperty(value = "角色名称")
    @TableField("role_name")
    private String roleName;

        @ApiModelProperty(value = "角色编码")
    @TableField("role_code")
    private String roleCode;

        @ApiModelProperty(value = "角色类型")
    @TableField("role_kind")
    private String roleKind;

        @ApiModelProperty(value = "备注")
    @TableField("role_comment")
    private String roleComment;


    @Override
    protected Serializable pkVal(){
            return this.roleId;
        }

}