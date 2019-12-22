package com.news.hr.system.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
/**
 * <p>
 * Permission对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_permission")
@ApiModel(value = "Permission对象", description = "权限表")
public class Permission extends Model<Permission> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "权限id")
    @TableId(value = "permission_id", type = IdType.AUTO)
        private Integer permissionId;

    @ApiModelProperty(value = "权限类型（菜单、操作、数据）")
    @TableField("permission_kind")
    private String permissionKind;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private String roleId;

    @ApiModelProperty(value = "资源id")
    @TableField("resource_id")
    private String resourceId;

    @ApiModelProperty(value = "资源标识")
    @TableField("resource_key")
    private String resourceKey;

    @ApiModelProperty(value = "资源名称")
    @TableField("resource_name")
    private String resourceName;

    @ApiModelProperty(value = "资源权限")
    @TableField("resource_auth")
    private String resourceAuth;

    @ApiModelProperty(value = "公式")
    @TableField("formula")
    private String formula;

    @ApiModelProperty(value = "资源值")
    @TableField("resource_value")
    private String resourceValue;

    @ApiModelProperty(value = "备注")
    @TableField("data_comment")
    private String dataComment;


    @Override
    protected Serializable pkVal(){
            return this.permissionId;
        }

}