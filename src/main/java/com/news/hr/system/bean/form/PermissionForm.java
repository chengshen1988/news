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
 * PermissionVO对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Permission对象", description="权限表")
public class PermissionForm{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "权限id")
    private Integer permissionId;

    @ApiModelProperty(value = "权限类型（菜单、操作、数据）")
    private String permissionKind;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "资源id")
    private String resourceId;

    @ApiModelProperty(value = "资源标识")
    private String resourceKey;

    @ApiModelProperty(value = "资源名称")
    private String resourceName;

    @ApiModelProperty(value = "资源权限")
    private String resourceAuth;

    @ApiModelProperty(value = "公式")
    private String formula;

    @ApiModelProperty(value = "资源值")
    private String resourceValue;

    @ApiModelProperty(value = "备注")
    private String dataComment;



}