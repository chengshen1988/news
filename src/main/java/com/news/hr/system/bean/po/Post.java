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
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
/**
 * <p>
 * Post对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_post")
@ApiModel(value = "Post对象", description = "岗位")
public class Post extends Model<Post> {

    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "主键")
    @TableId(value = "post_id", type = IdType.UUID)
        private String postId;

        @ApiModelProperty(value = "岗位编码")
    @TableField("post_code")
    private String postCode;

        @ApiModelProperty(value = "岗位名称")
    @TableField("post_name")
    private String postName;

        @ApiModelProperty(value = "组织机构编码")
    @TableField("org_code")
    private String orgCode;

        @ApiModelProperty(value = "排序")
    @TableField("data_order")
    private Integer dataOrder;


    @Override
    protected Serializable pkVal(){
            return this.postId;
        }

}