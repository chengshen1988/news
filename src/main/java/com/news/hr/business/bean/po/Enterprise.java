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
 * Enterprise对象
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
@TableName("tbl_enterprise")
@ApiModel(value = "Enterprise对象", description = "企业信息")
public class Enterprise extends Model<Enterprise> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "enterprise_id", type = IdType.AUTO)
                private Integer enterpriseId;

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

    @ApiModelProperty(value = "信息管理模块名称")
    @TableField("enter_name")
            private String enterName;

    @ApiModelProperty(value = "信息管理模块内容")
    @TableField("enter_context")
            private String enterContext;


    @Override
    protected Serializable pkVal(){
            return this.enterpriseId;
        }

}