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
 * NewsInfoImport对象
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
@Excel("NewsInfo导入")
public class NewsInfoImport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @ExcelField(value = "主键", required = true, comment = "请填写主键", width=150)
    private Integer newsInfoId;

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

    @ApiModelProperty(value = "一级分类")
    @ExcelField(value = "一级分类", required = true, comment = "请填写一级分类", width=150)
    private String firstLevel;

    @ApiModelProperty(value = "二级分类")
    @ExcelField(value = "二级分类", required = true, comment = "请填写二级分类", width=150)
    private String secondLevel;

    @ApiModelProperty(value = "地区")
    @ExcelField(value = "地区", required = true, comment = "请填写地区", width=150)
    private String region;

    @ApiModelProperty(value = "新闻名称")
    @ExcelField(value = "新闻名称", required = true, comment = "请填写新闻名称", width=150)
    private String newsName;

    @ApiModelProperty(value = "新闻来源")
    @ExcelField(value = "新闻来源", required = true, comment = "请填写新闻来源", width=150)
    private String newsSource;

    @ApiModelProperty(value = "记者ID")
    @ExcelField(value = "记者ID", required = true, comment = "请填写记者ID", width=150)
    private String newsmanId;

    @ApiModelProperty(value = "记者")
    @ExcelField(value = "记者", required = true, comment = "请填写记者", width=150)
    private String newsman;

    @ApiModelProperty(value = "新闻点击率")
    @ExcelField(value = "新闻点击率", required = true, comment = "请填写新闻点击率", width=150)
    private Integer newsClickRate;

    @ApiModelProperty(value = "简介")
    @ExcelField(value = "简介", required = true, comment = "请填写简介", width=150)
    private String introduction;

    @ApiModelProperty(value = "图片地址")
    @ExcelField(value = "图片地址", required = true, comment = "请填写图片地址", width=150)
    private String imageUrl;

    @ApiModelProperty(value = "视频地址")
    @ExcelField(value = "视频地址", required = true, comment = "请填写视频地址", width=150)
    private String videoUrl;

    @ApiModelProperty(value = "新闻内容")
    @ExcelField(value = "新闻内容", required = true, comment = "请填写新闻内容", width=150)
    private Integer contentId;



}