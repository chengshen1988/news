package com.news.hr.system.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
/**
 * <p>
 * Sequence对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_sequence")
@ApiModel(value = "Sequence对象", description = "序列表")
public class Sequence extends Model<Sequence> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "sequence_id", type = IdType.ASSIGN_UUID)
        private String sequenceId;

    @ApiModelProperty(value = "序列名称")
    @TableField("sequence_name")
    private String sequenceName;

    @ApiModelProperty(value = "当前取得数值")
    @TableField("current_value")
    private Long currentValue;

    @ApiModelProperty(value = "增幅值")
    @TableField("inct_value")
    private Integer inctValue;

    @ApiModelProperty(value = "队列初始值重置周期")
    @TableField("reset_period")
    private String resetPeriod;

    @ApiModelProperty(value = "应用表名")
    @TableField("comment")
    private String comment;


    @Override
    protected Serializable pkVal(){
            return this.sequenceId;
        }

}