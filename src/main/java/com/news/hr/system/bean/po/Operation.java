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


import java.time.LocalDate;
/**
 * <p>
 * Operation对象
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
@TableName("sys_operation")
@ApiModel(value = "Operation对象", description = "系统操作")
public class Operation extends Model<Operation> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "操作Id")
    @TableId(value = "operation_id", type = IdType.ASSIGN_UUID)
        private String operationId;

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

    @ApiModelProperty(value = "菜单Id")
    @TableField("menu_id")
    private String menuId;

    @ApiModelProperty(value = "操作类型")
    @TableField("operation_kind")
    private String operationKind;

    @ApiModelProperty(value = "操作名称")
    @TableField("operation_name")
    private String operationName;

    @ApiModelProperty(value = "操作编码")
    @TableField("operation_code")
    private String operationCode;

    @ApiModelProperty(value = "页面标识")
    @TableField("page_key")
    private String pageKey;

    @ApiModelProperty(value = "操作权限")
    @TableField("operation_auth")
    private String operationAuth;

    @ApiModelProperty(value = "备注")
    @TableField("operation_comment")
    private String operationComment;


    @Override
    protected Serializable pkVal(){
            return this.operationId;
        }

}