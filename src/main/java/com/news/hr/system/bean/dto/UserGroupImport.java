package com.news.hr.system.bean.dto;

import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.news.hr.framework.poi.annotation.Excel;
import com.news.hr.framework.poi.annotation.ExcelField;
/**
 * <p>
 * UserGroupImport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="UserGroup对象", description="")
@Excel("UserGroup导入")
public class UserGroupImport{

    private static final long serialVersionUID = 1L;
    @ExcelField(value = "XXX", required = true, comment = "请填写", width=150)
    private String userGroupId;

    @ApiModelProperty(value = "用户登录名")
    @ExcelField(value = "用户登录名", required = true, comment = "请填写用户登录名", width=150)
    private String userId;

    @ApiModelProperty(value = "分组Id")
    @ExcelField(value = "分组Id", required = true, comment = "请填写分组Id", width=150)
    private String groupId;



}