package com.news.hr.system.bean.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery{
    @ApiModelProperty(value = "分页页码")
    private Integer page;
    @ApiModelProperty(value = "分页页码总条数")
    private Integer limit;
    @ApiModelProperty(value = "删除标记")
    @Builder.Default
    private Integer delFlag = 0;
    @ApiModelProperty(value = "排序字段")
    private String orderBy;
    @ApiModelProperty(value = "asc,desc")
    private String order;
    @ApiModelProperty(value = "用户编码")
    private String userCode;
    @ApiModelProperty(value = "用户别名")
    private String username;
    @ApiModelProperty(value = "用户姓名")
    private String personalName;
    @ApiModelProperty(value = "用户邮箱")
    private String userMail;
    @ApiModelProperty(value = "身份证号码")
    private String certNo;
    @ApiModelProperty(value = "手机号码")
    private String userMobile;
    @ApiModelProperty(value = "用户ID")
    private String userId;


}
