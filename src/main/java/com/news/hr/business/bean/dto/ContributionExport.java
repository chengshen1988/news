package com.news.hr.business.bean.dto;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import com.news.hr.framework.poi.annotation.Excel;
import com.news.hr.framework.poi.annotation.ExcelField;
/**
 * <p>
 * ContributionExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Contribution对象", description="投稿管理")
@Excel("Contribution导出")
public class ContributionExport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "投稿id")
    @ExcelField(value = "投稿id", width=150)
    private String contributionId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @ExcelField(value = "删除标记（0：正常，1：删除）", width=150)
    private Integer delFlag;

    @ApiModelProperty(value = "排序字段（用户可以手动操作数据顺序时用到）")
    @ExcelField(value = "排序字段（用户可以手动操作数据顺序时用到）", width=150)
    private Integer dataOrder;

    @ApiModelProperty(value = "创建用户的登录名")
    @ExcelField(value = "创建用户的登录名", width=150)
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    @ExcelField(value = "创建用户的名称", width=150)
    private String cUserName;

    @ApiModelProperty(value = "创建时间")
    @ExcelField(value = "创建时间", width=150)
    private LocalDateTime ctime;

    @ApiModelProperty(value = "最后修改的用户的登录名")
    @ExcelField(value = "最后修改的用户的登录名", width=150)
    private String mUserId;

    @ApiModelProperty(value = "最后修改的用户的名称")
    @ExcelField(value = "最后修改的用户的名称", width=150)
    private String mUserName;

    @ApiModelProperty(value = "最后修改时间")
    @ExcelField(value = "最后修改时间", width=150)
    private LocalDateTime mtime;

    @ApiModelProperty(value = "作者姓名")
    @ExcelField(value = "作者姓名", width=150)
    private String authorName;

    @ApiModelProperty(value = "稿件标题")
    @ExcelField(value = "稿件标题", width=150)
    private String contributionName;

    @ApiModelProperty(value = "发送栏目")
    @ExcelField(value = "发送栏目", width=150)
    private String submitColumn;

    @ApiModelProperty(value = "审核状态")
    @ExcelField(value = "审核状态", width=150)
    private Integer submitStatus;

    @ApiModelProperty(value = "新闻信息ID")
    @ExcelField(value = "新闻信息ID", width=150)
    private Integer newsInfoId;



}