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
 * NewsInfo对象
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
@TableName("tbl_news_info")
@ApiModel(value = "NewsInfo对象", description = "新闻内容管理")
public class NewsInfo extends Model<NewsInfo> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "news_info_id", type = IdType.AUTO)
                private Integer newsInfoId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @TableField("del_flag")
            private Integer delFlag;

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

    @ApiModelProperty(value = "一级分类")
    @TableField("first_level")
            private String firstLevel;

    @ApiModelProperty(value = "二级分类")
    @TableField("second_level")
            private String secondLevel;

    @ApiModelProperty(value = "地区")
    @TableField("region")
            private String region;

    @ApiModelProperty(value = "新闻名称")
    @TableField("news_name")
            private String newsName;

    @ApiModelProperty(value = "新闻来源")
    @TableField("news_source")
            private String newsSource;

    @ApiModelProperty(value = "记者ID")
    @TableField("newsman_id")
            private String newsmanId;

    @ApiModelProperty(value = "记者")
    @TableField("newsman")
            private String newsman;

    @ApiModelProperty(value = "新闻点击率")
    @TableField("news_click_rate")
            private Integer newsClickRate;

    @ApiModelProperty(value = "简介")
    @TableField("introduction")
            private String introduction;

    @ApiModelProperty(value = "图片地址")
    @TableField("image_url")
            private String imageUrl;

    @ApiModelProperty(value = "视频地址")
    @TableField("video_url")
            private String videoUrl;

    @ApiModelProperty(value = "新闻内容")
    @TableField("content_id")
            private Integer contentId;


    @Override
    protected Serializable pkVal(){
            return this.newsInfoId;
        }

}