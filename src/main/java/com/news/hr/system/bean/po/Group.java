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
 * Group对象
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
@TableName("sys_group")
@ApiModel(value = "Group对象", description = "用户组")
public class Group extends Model<Group> {

    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "用户组Id")
    @TableId(value = "group_id", type = IdType.UUID)
        private String groupId;

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

        @ApiModelProperty(value = "所属组织机构编码")
    @TableField("org_code")
    private String orgCode;

        @ApiModelProperty(value = "用户组名称")
    @TableField("group_name")
    private String groupName;

        @ApiModelProperty(value = "用户组编码")
    @TableField("group_code")
    private String groupCode;

        @ApiModelProperty(value = "备注")
    @TableField("data_comment")
    private String dataComment;


    @Override
    protected Serializable pkVal(){
            return this.groupId;
        }

}