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
 * Newsman对象
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
@TableName("tbl_newsman")
@ApiModel(value = "Newsman对象", description = "")
public class Newsman extends Model<Newsman> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "newsman_id", type = IdType.ASSIGN_UUID)
                private String newsmanId;

    @ApiModelProperty(value = "排序")
    @TableField("data_order")
            private Integer dataOrder;

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

    @ApiModelProperty(value = "记者姓名")
    @TableField("newsman_name")
            private String newsmanName;

    @ApiModelProperty(value = "性别")
    @TableField("gender")
            private String gender;

    @ApiModelProperty(value = "记者证号码")
    @TableField("card_number")
            private String cardNumber;

    @ApiModelProperty(value = "身份证号码")
    @TableField("ID_card_no")
            private String idCardNo;

    @ApiModelProperty(value = "单位名称")
    @TableField("unit_name")
            private String unitName;

    @ApiModelProperty(value = "职务")
    @TableField("duty")
            private String duty;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发证日期")
    @TableField("issue_date")
            private LocalDateTime issueDate;

    @ApiModelProperty(value = "证件照片")
    @TableField("passport_photo")
            private String passportPhoto;

    @ApiModelProperty(value = "记者简历")
    @TableField("introduction")
            private String introduction;


    @Override
    protected Serializable pkVal(){
            return this.newsmanId;
        }

}