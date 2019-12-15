package com.news.hr.system.bean.vo;

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
 * UserGroupVO对象
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
public class UserGroupVo{

    private static final long serialVersionUID = 1L;
    private String userGroupId;

    @ApiModelProperty(value = "用户登录名")
    private String userId;

    @ApiModelProperty(value = "分组Id")
    private String groupId;



}