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
 * Region对象
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
@TableName("sys_region")
@ApiModel(value = "Region对象", description = "中国地区")
public class Region extends Model<Region> {

    private static final long serialVersionUID=1L;

    @TableId(value = "region_id", type = IdType.ASSIGN_UUID)
        private Integer regionId;

    @TableField("Name")
    private String Name;

    @TableField("Pid")
    private Integer Pid;


    @Override
    protected Serializable pkVal(){
            return this.regionId;
        }

}