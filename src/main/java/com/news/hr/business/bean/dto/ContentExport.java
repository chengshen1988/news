package com.news.hr.business.bean.dto;

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
 * ContentExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Content对象", description="文档内容")
@Excel("Content导出")
public class ContentExport{

    private static final long serialVersionUID = 1L;
    @ExcelField(value = "XXX", width=150)
    private Integer contentId;

    @ExcelField(value = "XXX", width=150)
    private String contentInfo;



}