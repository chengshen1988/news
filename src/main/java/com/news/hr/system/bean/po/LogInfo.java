package com.news.hr.system.bean.po;

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
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
/**
 * <p>
 * LogInfo对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_log_info")
@ApiModel(value = "LogInfo对象", description = "系统日志")
public class LogInfo extends Model<LogInfo> {

    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "系统日志Id")
    @TableId(value = "log_info_id", type = IdType.AUTO)
        private Integer logInfoId;

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

        @ApiModelProperty(value = "请求的远程IP")
    @TableField("remote_ip")
    private String remoteIp;

        @ApiModelProperty(value = "访问模块")
    @TableField("module")
    private String module;

        @ApiModelProperty(value = "日志类型")
    @TableField("log_kind")
    private String logKind;

        @ApiModelProperty(value = "日志消息")
    @TableField("message")
    private String message;

        @ApiModelProperty(value = "业务数据")
    @TableField("business_data")
    private String businessData;


    @Override
    protected Serializable pkVal(){
            return this.logInfoId;
        }

}