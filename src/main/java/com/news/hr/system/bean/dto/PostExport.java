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
 * PostExport对象
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
@Excel("Post导出")
public class PostExport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @ExcelField(value = "主键", width=150)
    private String postId;

    @ApiModelProperty(value = "岗位编码")
    @ExcelField(value = "岗位编码", width=150)
    private String postCode;

    @ApiModelProperty(value = "岗位名称")
    @ExcelField(value = "岗位名称", width=150)
    private String postName;

    @ApiModelProperty(value = "组织机构编码")
    @ExcelField(value = "组织机构编码", width=150)
    private String orgCode;

    @ApiModelProperty(value = "排序")
    @ExcelField(value = "排序", width=150)
    private Integer dataOrder;



}