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
 * OrgVO对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Org对象", description="机构")
public class OrgForm{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private Integer orgId;

    @ApiModelProperty(value = "组织机构编码")
    private String orgCode;

    @ApiModelProperty(value = "父级编码")
    private String parentCode;

    @ApiModelProperty(value = "简称")
    private String orgShortName;

    @ApiModelProperty(value = "全称")
    private String orgFullName;

    @ApiModelProperty(value = "1级组织机构")
    private String orgcode1;

    @ApiModelProperty(value = "2级组织机构")
    private String orgcode2;

    @ApiModelProperty(value = "3级组织机构")
    private String orgcode3;

    @ApiModelProperty(value = "4级组织机构")
    private String orgcode4;

    @ApiModelProperty(value = "5级组织机构")
    private String orgcode5;

    @ApiModelProperty(value = "机构级别")
    private String orgLevel;

    @ApiModelProperty(value = "直属机构编码")
    private String directOrgcode;

    @ApiModelProperty(value = "是否叶子节点")
    private String isLeaf;



}