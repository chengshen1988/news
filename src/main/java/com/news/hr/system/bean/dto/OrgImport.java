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
 * OrgImport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Org对象", description="机构")
@Excel("Org导入")
public class OrgImport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @ExcelField(value = "主键", required = true, comment = "请填写主键", width=150)
    private Integer orgId;

    @ApiModelProperty(value = "组织机构编码")
    @ExcelField(value = "组织机构编码", required = true, comment = "请填写组织机构编码", width=150)
    private String orgCode;

    @ApiModelProperty(value = "父级编码")
    @ExcelField(value = "父级编码", required = true, comment = "请填写父级编码", width=150)
    private String parentCode;

    @ApiModelProperty(value = "简称")
    @ExcelField(value = "简称", required = true, comment = "请填写简称", width=150)
    private String orgShortName;

    @ApiModelProperty(value = "全称")
    @ExcelField(value = "全称", required = true, comment = "请填写全称", width=150)
    private String orgFullName;

    @ApiModelProperty(value = "1级组织机构")
    @ExcelField(value = "1级组织机构", required = true, comment = "请填写1级组织机构", width=150)
    private String orgcode1;

    @ApiModelProperty(value = "2级组织机构")
    @ExcelField(value = "2级组织机构", required = true, comment = "请填写2级组织机构", width=150)
    private String orgcode2;

    @ApiModelProperty(value = "3级组织机构")
    @ExcelField(value = "3级组织机构", required = true, comment = "请填写3级组织机构", width=150)
    private String orgcode3;

    @ApiModelProperty(value = "4级组织机构")
    @ExcelField(value = "4级组织机构", required = true, comment = "请填写4级组织机构", width=150)
    private String orgcode4;

    @ApiModelProperty(value = "5级组织机构")
    @ExcelField(value = "5级组织机构", required = true, comment = "请填写5级组织机构", width=150)
    private String orgcode5;

    @ApiModelProperty(value = "机构级别")
    @ExcelField(value = "机构级别", required = true, comment = "请填写机构级别", width=150)
    private String orgLevel;

    @ApiModelProperty(value = "直属机构编码")
    @ExcelField(value = "直属机构编码", required = true, comment = "请填写直属机构编码", width=150)
    private String directOrgcode;

    @ApiModelProperty(value = "是否叶子节点")
    @ExcelField(value = "是否叶子节点", required = true, comment = "请填写是否叶子节点", width=150)
    private String isLeaf;



}