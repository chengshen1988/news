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
 * User对象
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
@TableName("sys_user")
@ApiModel(value = "User对象", description = "用户")
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @TableId(value = "user_id", type = IdType.UUID)
        private String userId;

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

        @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

        @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

        @ApiModelProperty(value = "用户编号")
    @TableField("user_code")
    private String userCode;

        @ApiModelProperty(value = "个人姓名")
    @TableField("personal_name")
    private String personalName;

        @ApiModelProperty(value = "机构编码")
    @TableField("org_code")
    private String orgCode;

        @ApiModelProperty(value = "岗位编码")
    @TableField("post_code")
    private String postCode;

        @ApiModelProperty(value = "用户性别")
    @TableField("user_sex")
    private String userSex;

        @ApiModelProperty(value = "用户类别")
    @TableField("user_kind")
    private String userKind;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "最近登录系统时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

        @ApiModelProperty(value = "身份证号")
    @TableField("cert_no")
    private String certNo;

        @ApiModelProperty(value = "用户邮箱地址")
    @TableField("user_mail")
    private String userMail;

        @ApiModelProperty(value = "用户座机号码")
    @TableField("user_telephone")
    private String userTelephone;

        @ApiModelProperty(value = "手机号码")
    @TableField("user_mobile")
    private String userMobile;

        @ApiModelProperty(value = "用户备注")
    @TableField("user_comment")
    private String userComment;

        @ApiModelProperty(value = "登录失败次数")
    @TableField("login_failure")
    private Integer loginFailure;

        @ApiModelProperty(value = "登录次数")
    @TableField("login_count")
    private Integer loginCount;

        @ApiModelProperty(value = "用户状态（0：初建用户，1：正常用户）")
    @TableField("user_status")
    private Integer userStatus;

        @ApiModelProperty(value = "用户照片地址")
    @TableField("user_photo")
    private String userPhoto;


    @Override
    protected Serializable pkVal(){
            return this.userId;
        }

}