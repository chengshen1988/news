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
 * Contribution对象
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
@TableName("tbl_contribution")
@ApiModel(value = "Contribution对象", description = "投稿管理")
public class Contribution extends Model<Contribution> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "投稿id")
    @TableId(value = "contribution_id", type = IdType.ASSIGN_UUID)
                private String contributionId;

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

    @ApiModelProperty(value = "作者姓名")
    @TableField("author_name")
            private String authorName;

    @ApiModelProperty(value = "稿件标题")
    @TableField("contribution_name")
            private String contributionName;

    @ApiModelProperty(value = "发送栏目")
    @TableField("submit_column")
            private String submitColumn;

    @ApiModelProperty(value = "审核状态")
    @TableField("submit_status")
            private Integer submitStatus;

    @ApiModelProperty(value = "新闻信息ID")
    @TableField("news_info_id")
            private Integer newsInfoId;


    @Override
    protected Serializable pkVal(){
            return this.contributionId;
        }

}