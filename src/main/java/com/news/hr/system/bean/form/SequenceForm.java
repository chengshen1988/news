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
 * SequenceVO对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Sequence对象", description="序列表")
public class SequenceForm{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private String sequenceId;

    @ApiModelProperty(value = "序列名称")
    private String sequenceName;

    @ApiModelProperty(value = "当前取得数值")
    private Long currentValue;

    @ApiModelProperty(value = "增幅值")
    private Integer inctValue;

    @ApiModelProperty(value = "队列初始值重置周期")
    private String resetPeriod;

    @ApiModelProperty(value = "应用表名")
    private String comment;



}