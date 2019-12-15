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
 * Org对象
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
@TableName("sys_org")
@ApiModel(value = "Org对象", description = "机构")
public class Org extends Model<Org> {

    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "主键")
    @TableId(value = "org_id", type = IdType.AUTO)
        private Integer orgId;

        @ApiModelProperty(value = "组织机构编码")
    @TableField("org_code")
    private String orgCode;

        @ApiModelProperty(value = "父级编码")
    @TableField("parent_code")
    private String parentCode;

        @ApiModelProperty(value = "简称")
    @TableField("org_short_name")
    private String orgShortName;

        @ApiModelProperty(value = "全称")
    @TableField("org_full_name")
    private String orgFullName;

        @ApiModelProperty(value = "1级组织机构")
    @TableField("orgcode1")
    private String orgcode1;

        @ApiModelProperty(value = "2级组织机构")
    @TableField("orgcode2")
    private String orgcode2;

        @ApiModelProperty(value = "3级组织机构")
    @TableField("orgcode3")
    private String orgcode3;

        @ApiModelProperty(value = "4级组织机构")
    @TableField("orgcode4")
    private String orgcode4;

        @ApiModelProperty(value = "5级组织机构")
    @TableField("orgcode5")
    private String orgcode5;

        @ApiModelProperty(value = "机构级别")
    @TableField("org_level")
    private String orgLevel;

        @ApiModelProperty(value = "直属机构编码")
    @TableField("direct_orgcode")
    private String directOrgcode;

        @ApiModelProperty(value = "是否叶子节点")
    @TableField("is_leaf")
    private String isLeaf;


    @Override
    protected Serializable pkVal(){
            return this.orgId;
        }

}