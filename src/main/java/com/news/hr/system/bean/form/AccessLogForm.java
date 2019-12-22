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
 * AccessLogVO对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="AccessLog对象", description="访问日志")
public class AccessLogForm{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "访问日志Id")
    private Integer accessLogId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    private Integer delFlag;

    @ApiModelProperty(value = "创建用户的登录名")
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    private String cUserName;

    @ApiModelProperty(value = "访问类型")
    private String accessKind;

    @ApiModelProperty(value = "请求的远程IP")
    private String remoteIp;

    @ApiModelProperty(value = "访问模块")
    private String moduleId;

    @ApiModelProperty(value = "模块名称")
    private String moduleName;

    @ApiModelProperty(value = "请求地址")
    private String url;

    @ApiModelProperty(value = "备注")
    private String dataComment;



}