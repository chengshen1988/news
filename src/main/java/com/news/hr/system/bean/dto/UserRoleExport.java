package com.news.hr.system.bean.dto;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import com.news.hr.framework.poi.annotation.Excel;
import com.news.hr.framework.poi.annotation.ExcelField;
/**
 * <p>
 * UserRoleExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="UserRole对象", description="用户角色关联表")
@Excel("UserRole导出")
public class UserRoleExport{

    private static final long serialVersionUID = 1L;
    @ExcelField(value = "XXX", width=150)
    private String userRoleId;

    @ExcelField(value = "XXX", width=150)
    private String userId;

    @ExcelField(value = "XXX", width=150)
    private String roleId;



}