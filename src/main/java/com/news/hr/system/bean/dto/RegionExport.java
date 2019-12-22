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
 * RegionExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Region对象", description="中国地区")
@Excel("Region导出")
public class RegionExport{

    private static final long serialVersionUID = 1L;
    @ExcelField(value = "XXX", width=150)
    private Integer regionId;

    @ExcelField(value = "XXX", width=150)
    private String Name;

    @ExcelField(value = "XXX", width=150)
    private Integer Pid;



}