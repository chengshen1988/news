package com.news.hr.framework.config.security.entity;

import com.news.hr.system.bean.po.Org;
import com.news.hr.system.bean.po.Permission;
import com.news.hr.system.bean.po.Post;
import com.news.hr.system.bean.po.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ChenSeen
 * @Date 2019/12/15 3:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserSession {

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    private Integer delFlag;

    @ApiModelProperty(value = "排序字段（用户可以手动操作数据顺序时用到）")
    private Integer dataOrder;

    @ApiModelProperty(value = "创建用户的登录名")
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    private String cUserName;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "最后修改的用户的登录名")
    private String mUserId;

    @ApiModelProperty(value = "最后修改的用户的名称")
    private String mUserName;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime mtime;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "用户编号")
    private String userCode;

    @ApiModelProperty(value = "个人姓名")
    private String personalName;

    @ApiModelProperty(value = "机构编码")
    private String orgCode;

    @ApiModelProperty(value = "岗位编码")
    private String postCode;

    @ApiModelProperty(value = "用户性别")
    private String userSex;

    @ApiModelProperty(value = "用户类别")
    private String userKind;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最近登录系统时间")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "身份证号")
    private String certNo;

    @ApiModelProperty(value = "用户邮箱地址")
    private String userMail;

    @ApiModelProperty(value = "用户座机号码")
    private String userTelephone;

    @ApiModelProperty(value = "手机号码")
    private String userMobile;

    @ApiModelProperty(value = "用户备注")
    private String userComment;

    @ApiModelProperty(value = "登录失败次数")
    private Integer loginFailure;

    @ApiModelProperty(value = "登录次数")
    private Integer loginCount;

    @ApiModelProperty(value = "用户状态（0：初建用户，1：正常用户）")
    private Integer userStatus;

    @ApiModelProperty(value = "用户照片地址")
    private String userPhoto;


    @ApiModelProperty(value = "机构信息")
    private Org org;

    @ApiModelProperty(value = "岗位信息")
    private Post post;

    @ApiModelProperty(value = "角色信息")
    private List<Role> roles;

    @ApiModelProperty(value = "资源信息")
    private List<Permission> permissions;

}
