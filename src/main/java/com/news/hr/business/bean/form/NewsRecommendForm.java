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
 * NewsRecommendVO对象
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
public class NewsRecommendForm{

    private static final long serialVersionUID = 1L;
    private Integer newsRecommendId;

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

    @ApiModelProperty(value = "tbl_news_info主键")
    private Integer newsInfoId;

    @ApiModelProperty(value = "tbl_link_manage主键")
    private Integer linkManageId;

    @ApiModelProperty(value = "推荐:0,不选择,1,选择")
    private Integer recommend;

    @ApiModelProperty(value = "头条:0,不选择,1选择")
    private Integer headlines;

    @ApiModelProperty(value = "滚动:0,不选择,1,选择")
    private Integer scrollBar;

    @ApiModelProperty(value = "幻灯:0,不选择,1选择")
    private Integer slideShow;



}