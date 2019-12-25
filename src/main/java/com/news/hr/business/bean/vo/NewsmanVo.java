package com.news.hr.business.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * NewsmanVO对象
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
public class NewsmanVo{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private String newsmanId;

    @ApiModelProperty(value = "排序")
    private Integer dataOrder;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    private Integer delFlag;

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

    @ApiModelProperty(value = "记者姓名")
    private String newsmanName;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "记者证号码")
    private String cardNumber;

    @ApiModelProperty(value = "身份证号码")
    private String idCardNo;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "职务")
    private String duty;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发证日期")
    private LocalDateTime issueDate;

    @ApiModelProperty(value = "证件照片")
    private String passportPhoto;

    @ApiModelProperty(value = "记者简历")
    private String introduction;



}