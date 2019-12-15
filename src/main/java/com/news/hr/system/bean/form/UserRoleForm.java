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
 * UserRoleVO对象
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
public class UserRoleForm{

    private static final long serialVersionUID = 1L;
    private String userRoleId;

    private String userId;

    private String roleId;



}