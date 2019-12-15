package com.news.hr.system.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * Dict对象
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
@TableName("sys_dict")
@ApiModel(value = "Dict对象", description = "数据字典")
public class Dict extends Model<Dict> {

    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "数据字典Id")
    @TableId(value = "dict_id", type = IdType.UUID)
        private String dictId;

        @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @TableField("del_flag")
    private Integer delFlag;

        @ApiModelProperty(value = "排序字段（用户可以手动操作数据顺序时用到）")
    @TableField("data_order")
    private Integer dataOrder;

        @ApiModelProperty(value = "创建用户的登录名")
    @TableField("c_user_id")
    private String cUserId;

        @ApiModelProperty(value = "创建用户的名称")
    @TableField("c_user_name")
    private String cUserName;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "创建时间")
    @TableField(value = "ctime", fill = FieldFill.INSERT)
    private LocalDateTime ctime;

        @ApiModelProperty(value = "最后修改的用户的登录名")
    @TableField("m_user_id")
    private String mUserId;

        @ApiModelProperty(value = "最后修改的用户的名称")
    @TableField("m_user_name")
    private String mUserName;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "最后修改时间")
    @TableField(value = "mtime", fill = FieldFill.UPDATE)
    private LocalDateTime mtime;

        @ApiModelProperty(value = "父级Id")
    @TableField("dict_parent")
    private String dictParent;

        @ApiModelProperty(value = "路径")
    @TableField("dict_path")
    private String dictPath;

        @ApiModelProperty(value = "级别")
    @TableField("dict_level")
    private Integer dictLevel;

        @ApiModelProperty(value = "是否叶子节电")
    @TableField("is_leaf")
    private Integer isLeaf;

        @ApiModelProperty(value = "类型（分类、值）")
    @TableField("dict_kind")
    private String dictKind;

        @ApiModelProperty(value = "显示值")
    @TableField("dict_display")
    private String dictDisplay;

        @ApiModelProperty(value = "实际值")
    @TableField("dict_value")
    private String dictValue;

        @ApiModelProperty(value = "备注")
    @TableField("dict_comment")
    private String dictComment;


    @Override
    protected Serializable pkVal(){
            return this.dictId;
        }

}