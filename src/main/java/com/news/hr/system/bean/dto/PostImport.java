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
 * PostImport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Post对象", description="岗位")
@Excel("Post导入")
public class PostImport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @ExcelField(value = "主键", required = true, comment = "请填写主键", width=150)
    private String postId;

    @ApiModelProperty(value = "岗位编码")
    @ExcelField(value = "岗位编码", required = true, comment = "请填写岗位编码", width=150)
    private String postCode;

    @ApiModelProperty(value = "岗位名称")
    @ExcelField(value = "岗位名称", required = true, comment = "请填写岗位名称", width=150)
    private String postName;

    @ApiModelProperty(value = "组织机构编码")
    @ExcelField(value = "组织机构编码", required = true, comment = "请填写组织机构编码", width=150)
    private String orgCode;

    @ApiModelProperty(value = "排序")
    @ExcelField(value = "排序", required = true, comment = "请填写排序", width=150)
    private Integer dataOrder;



}