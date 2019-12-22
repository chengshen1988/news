package com.news.hr.system.bean.query;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统操作
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OperationQuery{
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
}
