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
 * LinkManage对象
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
@TableName("tbl_link_manage")
@ApiModel(value = "LinkManage对象", description = "链接管理")
public class LinkManage extends Model<LinkManage> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "链接主键")
    @TableId(value = "link_manage_id", type = IdType.AUTO)
                private Integer linkManageId;

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

    @ApiModelProperty(value = "链接名称")
    @TableField("link_name")
            private String linkName;

    @ApiModelProperty(value = "链接地址")
    @TableField("link_url")
            private String linkUrl;

    @ApiModelProperty(value = "所属分类")
    @TableField("link_category")
            private String linkCategory;

    @ApiModelProperty(value = "所属图片")
    @TableField("image_url")
            private String imageUrl;


    @Override
    protected Serializable pkVal(){
            return this.linkManageId;
        }

}