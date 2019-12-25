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
 * NewsInfoVO对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="NewsInfo对象", description="新闻内容管理")
public class NewsInfoForm{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private Integer newsInfoId;

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

    @ApiModelProperty(value = "一级分类")
    private String firstLevel;

    @ApiModelProperty(value = "二级分类")
    private String secondLevel;

    @ApiModelProperty(value = "地区")
    private String region;

    @ApiModelProperty(value = "新闻名称")
    private String newsName;

    @ApiModelProperty(value = "新闻来源")
    private String newsSource;

    @ApiModelProperty(value = "记者ID")
    private String newsmanId;

    @ApiModelProperty(value = "记者")
    private String newsman;

    @ApiModelProperty(value = "新闻点击率")
    private Integer newsClickRate;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "图片地址")
    private String imageUrl;

    @ApiModelProperty(value = "视频地址")
    private String videoUrl;

    @ApiModelProperty(value = "新闻内容")
    private Integer contentId;



}