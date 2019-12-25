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
 * NewsRecommendImport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="NewsRecommend对象", description="")
@Excel("NewsRecommend导入")
public class NewsRecommendImport{

    private static final long serialVersionUID = 1L;
    @ExcelField(value = "XXX", required = true, comment = "请填写", width=150)
    private Integer newsRecommendId;

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

    @ApiModelProperty(value = "tbl_news_info主键")
    @ExcelField(value = "tbl_news_info主键", required = true, comment = "请填写tbl_news_info主键", width=150)
    private Integer newsInfoId;

    @ApiModelProperty(value = "tbl_link_manage主键")
    @ExcelField(value = "tbl_link_manage主键", required = true, comment = "请填写tbl_link_manage主键", width=150)
    private Integer linkManageId;

    @ApiModelProperty(value = "推荐:0,不选择,1,选择")
    @ExcelField(value = "推荐:0,不选择,1,选择", required = true, comment = "请填写推荐:0,不选择,1,选择", width=150)
    private Integer recommend;

    @ApiModelProperty(value = "头条:0,不选择,1选择")
    @ExcelField(value = "头条:0,不选择,1选择", required = true, comment = "请填写头条:0,不选择,1选择", width=150)
    private Integer headlines;

    @ApiModelProperty(value = "滚动:0,不选择,1,选择")
    @ExcelField(value = "滚动:0,不选择,1,选择", required = true, comment = "请填写滚动:0,不选择,1,选择", width=150)
    private Integer scrollBar;

    @ApiModelProperty(value = "幻灯:0,不选择,1选择")
    @ExcelField(value = "幻灯:0,不选择,1选择", required = true, comment = "请填写幻灯:0,不选择,1选择", width=150)
    private Integer slideShow;



}