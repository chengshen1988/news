package com.news.hr.business.bean.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import java.io.Serializable;


/**
 * <p>
 * LinkManageVO对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="LinkManage对象", description="链接管理")
public class LinkManageForm{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "链接主键")
    private Integer linkManageId;

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

    @ApiModelProperty(value = "链接名称")
    private String linkName;

    @ApiModelProperty(value = "链接地址")
    private String linkUrl;

    @ApiModelProperty(value = "所属分类")
    private String linkCategory;

    @ApiModelProperty(value = "所属图片")
    private String imageUrl;



}