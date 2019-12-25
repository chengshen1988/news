package com.news.hr.business.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
/**
 * <p>
 * NewsRecommend对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_news_recommend")
@ApiModel(value = "NewsRecommend对象", description = "")
public class NewsRecommend extends Model<NewsRecommend> {

    private static final long serialVersionUID=1L;

    @TableId(value = "news_recommend_id", type = IdType.AUTO)
                private Integer newsRecommendId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @TableField("del_flag")
            private Integer delFlag;

    @ApiModelProperty(value = "排序字段（用户可以手动操作数据顺序时用到）")
    @TableField("data_order")
            private Integer dataOrder;

    @ApiModelProperty(value = "创建用户的登录名")
    @TableField("c_user_id")
            private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    @TableField("c_user_name")
            private String cUserName;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
        @TableField(value = "ctime", fill = FieldFill.INSERT)
            private LocalDateTime ctime;

    @ApiModelProperty(value = "最后修改的用户的登录名")
    @TableField("m_user_id")
            private String mUserId;

    @ApiModelProperty(value = "最后修改的用户的名称")
    @TableField("m_user_name")
            private String mUserName;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后修改时间")
        @TableField(value = "mtime", fill = FieldFill.UPDATE)
            private LocalDateTime mtime;

    @ApiModelProperty(value = "tbl_news_info主键")
    @TableField("news_info_id")
            private Integer newsInfoId;

    @ApiModelProperty(value = "tbl_link_manage主键")
    @TableField("link_manage_id")
            private Integer linkManageId;

    @ApiModelProperty(value = "推荐:0,不选择,1,选择")
    @TableField("recommend")
            private Integer recommend;

    @ApiModelProperty(value = "头条:0,不选择,1选择")
    @TableField("headlines")
            private Integer headlines;

    @ApiModelProperty(value = "滚动:0,不选择,1,选择")
    @TableField("scroll_bar")
            private Integer scrollBar;

    @ApiModelProperty(value = "幻灯:0,不选择,1选择")
    @TableField("slide_show")
            private Integer slideShow;


    @Override
    protected Serializable pkVal(){
            return this.newsRecommendId;
        }

}