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
 * UserImport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="User对象", description="用户")
@Excel("User导入")
public class UserImport{

    private static final long serialVersionUID = 1L;
    @ExcelField(value = "XXX", required = true, comment = "请填写", width=150)
    private String userId;

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

    @ApiModelProperty(value = "用户名")
    @ExcelField(value = "用户名", required = true, comment = "请填写用户名", width=150)
    private String username;

    @ApiModelProperty(value = "密码")
    @ExcelField(value = "密码", required = true, comment = "请填写密码", width=150)
    private String password;

    @ApiModelProperty(value = "用户编号")
    @ExcelField(value = "用户编号", required = true, comment = "请填写用户编号", width=150)
    private String userCode;

    @ApiModelProperty(value = "个人姓名")
    @ExcelField(value = "个人姓名", required = true, comment = "请填写个人姓名", width=150)
    private String personalName;

    @ApiModelProperty(value = "机构编码")
    @ExcelField(value = "机构编码", required = true, comment = "请填写机构编码", width=150)
    private String orgCode;

    @ApiModelProperty(value = "岗位编码")
    @ExcelField(value = "岗位编码", required = true, comment = "请填写岗位编码", width=150)
    private String postCode;

    @ApiModelProperty(value = "用户性别")
    @ExcelField(value = "用户性别", required = true, comment = "请填写用户性别", width=150)
    private String userSex;

    @ApiModelProperty(value = "用户类别")
    @ExcelField(value = "用户类别", required = true, comment = "请填写用户类别", width=150)
    private String userKind;

    @ApiModelProperty(value = "最近登录系统时间")
    @ExcelField(value = "最近登录系统时间", required = true, comment = "请填写最近登录系统时间", width=150)
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "身份证号")
    @ExcelField(value = "身份证号", required = true, comment = "请填写身份证号", width=150)
    private String certNo;

    @ApiModelProperty(value = "用户邮箱地址")
    @ExcelField(value = "用户邮箱地址", required = true, comment = "请填写用户邮箱地址", width=150)
    private String userMail;

    @ApiModelProperty(value = "用户座机号码")
    @ExcelField(value = "用户座机号码", required = true, comment = "请填写用户座机号码", width=150)
    private String userTelephone;

    @ApiModelProperty(value = "手机号码")
    @ExcelField(value = "手机号码", required = true, comment = "请填写手机号码", width=150)
    private String userMobile;

    @ApiModelProperty(value = "用户备注")
    @ExcelField(value = "用户备注", required = true, comment = "请填写用户备注", width=150)
    private String userComment;

    @ApiModelProperty(value = "登录失败次数")
    @ExcelField(value = "登录失败次数", required = true, comment = "请填写登录失败次数", width=150)
    private Integer loginFailure;

    @ApiModelProperty(value = "登录次数")
    @ExcelField(value = "登录次数", required = true, comment = "请填写登录次数", width=150)
    private Integer loginCount;

    @ApiModelProperty(value = "用户状态（0：初建用户，1：正常用户）")
    @ExcelField(value = "用户状态（0：初建用户，1：正常用户）", required = true, comment = "请填写用户状态（0：初建用户，1：正常用户）", width=150)
    private Integer userStatus;

    @ApiModelProperty(value = "用户照片地址")
    @ExcelField(value = "用户照片地址", required = true, comment = "请填写用户照片地址", width=150)
    private String userPhoto;



}