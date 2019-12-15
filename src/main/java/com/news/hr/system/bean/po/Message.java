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
 * Message对象
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
@TableName("sys_message")
@ApiModel(value = "Message对象", description = "系统消息")
public class Message extends Model<Message> {

    private static final long serialVersionUID=1L;

    @TableId(value = "message_id", type = IdType.AUTO)
        private Integer messageId;

        @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @TableField("del_flag")
    private Integer delFlag;

        @ApiModelProperty(value = "创建用户的登录名")
    @TableField("c_user_id")
    private String cUserId;

        @ApiModelProperty(value = "创建用户的名称")
    @TableField("c_user_name")
    private String cUserName;

        @ApiModelProperty(value = "创建用户的机构编码")
    @TableField("c_unit_id")
    private String cUnitId;

        @ApiModelProperty(value = "创建用户的岗位编码")
    @TableField("c_post_id")
    private String cPostId;

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

        @ApiModelProperty(value = "业务类型")
    @TableField("business_type")
    private String businessType;

        @ApiModelProperty(value = "业务ID")
    @TableField("business_id")
    private String businessId;

        @ApiModelProperty(value = "消息类别")
    @TableField("message_kind")
    private String messageKind;

        @ApiModelProperty(value = "消息主题")
    @TableField("message_title")
    private String messageTitle;

        @ApiModelProperty(value = "消息内容")
    @TableField("message_content")
    private String messageContent;


    @Override
    protected Serializable pkVal(){
            return this.messageId;
        }

}