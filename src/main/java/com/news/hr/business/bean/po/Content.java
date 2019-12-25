package com.news.hr.business.bean.po;

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
 * Content对象
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
@TableName("tbl_content")
@ApiModel(value = "Content对象", description = "文档内容")
public class Content extends Model<Content> {

    private static final long serialVersionUID=1L;

    @TableId(value = "content_id", type = IdType.AUTO)
                private Integer contentId;

    @TableField("content_info")
            private String contentInfo;


    @Override
    protected Serializable pkVal(){
            return this.contentId;
        }

}