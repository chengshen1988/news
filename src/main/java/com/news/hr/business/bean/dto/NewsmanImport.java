package com.news.hr.business.bean.dto;

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
 * NewsmanImport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Newsman对象", description="")
@Excel("Newsman导入")
public class NewsmanImport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @ExcelField(value = "主键", required = true, comment = "请填写主键", width=150)
    private String newsmanId;

    @ApiModelProperty(value = "排序")
    @ExcelField(value = "排序", required = true, comment = "请填写排序", width=150)
    private Integer dataOrder;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @ExcelField(value = "删除标记（0：正常，1：删除）", required = true, comment = "请填写删除标记（0：正常，1：删除）", width=150)
    private Integer delFlag;

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

    @ApiModelProperty(value = "记者姓名")
    @ExcelField(value = "记者姓名", required = true, comment = "请填写记者姓名", width=150)
    private String newsmanName;

    @ApiModelProperty(value = "性别")
    @ExcelField(value = "性别", required = true, comment = "请填写性别", width=150)
    private String gender;

    @ApiModelProperty(value = "记者证号码")
    @ExcelField(value = "记者证号码", required = true, comment = "请填写记者证号码", width=150)
    private String cardNumber;

    @ApiModelProperty(value = "身份证号码")
    @ExcelField(value = "身份证号码", required = true, comment = "请填写身份证号码", width=150)
    private String idCardNo;

    @ApiModelProperty(value = "单位名称")
    @ExcelField(value = "单位名称", required = true, comment = "请填写单位名称", width=150)
    private String unitName;

    @ApiModelProperty(value = "职务")
    @ExcelField(value = "职务", required = true, comment = "请填写职务", width=150)
    private String duty;

    @ApiModelProperty(value = "发证日期")
    @ExcelField(value = "发证日期", required = true, comment = "请填写发证日期", width=150)
    private LocalDateTime issueDate;

    @ApiModelProperty(value = "证件照片")
    @ExcelField(value = "证件照片", required = true, comment = "请填写证件照片", width=150)
    private String passportPhoto;

    @ApiModelProperty(value = "记者简历")
    @ExcelField(value = "记者简历", required = true, comment = "请填写记者简历", width=150)
    private String introduction;



}