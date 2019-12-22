package com.news.hr.system.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * AccessLog对象
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
@TableName("sys_access_log")
@ApiModel(value = "AccessLog对象", description = "访问日志")
public class AccessLog extends Model<AccessLog> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "访问日志Id")
    @TableId(value = "access_log_id", type = IdType.AUTO)
        private Integer accessLogId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @TableField("del_flag")
    private Integer delFlag;

    @ApiModelProperty(value = "创建用户的登录名")
    @TableField("c_user_id")
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    @TableField("c_user_name")
    private String cUserName;

    @ApiModelProperty(value = "访问类型")
    @TableField("access_kind")
    private String accessKind;

    @ApiModelProperty(value = "请求的远程IP")
    @TableField("remote_ip")
    private String remoteIp;

    @ApiModelProperty(value = "访问模块")
    @TableField("module_id")
    private String moduleId;

    @ApiModelProperty(value = "模块名称")
    @TableField("module_name")
    private String moduleName;

    @ApiModelProperty(value = "请求地址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "备注")
    @TableField("data_comment")
    private String dataComment;


    @Override
    protected Serializable pkVal(){
            return this.accessLogId;
        }

}