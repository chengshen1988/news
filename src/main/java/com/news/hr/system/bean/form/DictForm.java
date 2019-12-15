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
 * DictVO对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Dict对象", description="数据字典")
public class DictForm{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "数据字典Id")
    private String dictId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    private Integer delFlag;

    @ApiModelProperty(value = "排序字段（用户可以手动操作数据顺序时用到）")
    private Integer dataOrder;

    @ApiModelProperty(value = "创建用户的登录名")
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    private String cUserName;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime ctime;

    @ApiModelProperty(value = "最后修改的用户的登录名")
    private String mUserId;

    @ApiModelProperty(value = "最后修改的用户的名称")
    private String mUserName;

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime mtime;

    @ApiModelProperty(value = "父级Id")
    private String dictParent;

    @ApiModelProperty(value = "路径")
    private String dictPath;

    @ApiModelProperty(value = "级别")
    private Integer dictLevel;

    @ApiModelProperty(value = "是否叶子节电")
    private Integer isLeaf;

    @ApiModelProperty(value = "类型（分类、值）")
    private String dictKind;

    @ApiModelProperty(value = "显示值")
    private String dictDisplay;

    @ApiModelProperty(value = "实际值")
    private String dictValue;

    @ApiModelProperty(value = "备注")
    private String dictComment;



}