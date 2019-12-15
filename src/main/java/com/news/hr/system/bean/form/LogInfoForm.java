package com.news.hr.system.bean.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * LogInfoVO对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="LogInfo对象", description="系统日志")
public class LogInfoForm{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "系统日志Id")
    private Integer logInfoId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    private Integer delFlag;

    @ApiModelProperty(value = "创建用户的登录名")
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    private String cUserName;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "请求的远程IP")
    private String remoteIp;

    @ApiModelProperty(value = "访问模块")
    private String module;

    @ApiModelProperty(value = "日志类型")
    private String logKind;

    @ApiModelProperty(value = "日志消息")
    private String message;

    @ApiModelProperty(value = "业务数据")
    private String businessData;



}