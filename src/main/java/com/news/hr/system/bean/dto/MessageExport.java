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
 * MessageExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Message对象", description="系统消息")
@Excel("Message导出")
public class MessageExport{

    private static final long serialVersionUID = 1L;
    @ExcelField(value = "XXX", width=150)
    private Integer messageId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @ExcelField(value = "删除标记（0：正常，1：删除）", width=150)
    private Integer delFlag;

    @ApiModelProperty(value = "创建用户的登录名")
    @ExcelField(value = "创建用户的登录名", width=150)
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    @ExcelField(value = "创建用户的名称", width=150)
    private String cUserName;

    @ApiModelProperty(value = "创建用户的机构编码")
    @ExcelField(value = "创建用户的机构编码", width=150)
    private String cUnitId;

    @ApiModelProperty(value = "创建用户的岗位编码")
    @ExcelField(value = "创建用户的岗位编码", width=150)
    private String cPostId;

    @ApiModelProperty(value = "创建时间")
    @ExcelField(value = "创建时间", width=150)
    private LocalDateTime ctime;

    @ApiModelProperty(value = "最后修改的用户的登录名")
    @ExcelField(value = "最后修改的用户的登录名", width=150)
    private String mUserId;

    @ApiModelProperty(value = "最后修改的用户的名称")
    @ExcelField(value = "最后修改的用户的名称", width=150)
    private String mUserName;

    @ApiModelProperty(value = "最后修改时间")
    @ExcelField(value = "最后修改时间", width=150)
    private LocalDateTime mtime;

    @ApiModelProperty(value = "业务类型")
    @ExcelField(value = "业务类型", width=150)
    private String businessType;

    @ApiModelProperty(value = "业务ID")
    @ExcelField(value = "业务ID", width=150)
    private String businessId;

    @ApiModelProperty(value = "消息类别")
    @ExcelField(value = "消息类别", width=150)
    private String messageKind;

    @ApiModelProperty(value = "消息主题")
    @ExcelField(value = "消息主题", width=150)
    private String messageTitle;

    @ApiModelProperty(value = "消息内容")
    @ExcelField(value = "消息内容", width=150)
    private String messageContent;



}