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
 * SequenceExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Sequence对象", description="序列表")
@Excel("Sequence导出")
public class SequenceExport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    @ExcelField(value = "主键", width=150)
    private String sequenceId;

    @ApiModelProperty(value = "序列名称")
    @ExcelField(value = "序列名称", width=150)
    private String sequenceName;

    @ApiModelProperty(value = "当前取得数值")
    @ExcelField(value = "当前取得数值", width=150)
    private Long currentValue;

    @ApiModelProperty(value = "增幅值")
    @ExcelField(value = "增幅值", width=150)
    private Integer inctValue;

    @ApiModelProperty(value = "队列初始值重置周期")
    @ExcelField(value = "队列初始值重置周期", width=150)
    private String resetPeriod;

    @ApiModelProperty(value = "应用表名")
    @ExcelField(value = "应用表名", width=150)
    private String comment;



}