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
 * MessageUserExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="MessageUser对象", description="")
@Excel("MessageUser导出")
public class MessageUserExport{

    private static final long serialVersionUID = 1L;
    @ExcelField(value = "XXX", width=150)
    private Integer messageUserId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @ExcelField(value = "删除标记（0：正常，1：删除）", width=150)
    private Integer delFlag;

    @ApiModelProperty(value = "创建用户的登录名")
    @ExcelField(value = "创建用户的登录名", width=150)
    private String cUserId;

    @ApiModelProperty(value = "创建用户的名称")
    @ExcelField(value = "创建用户的名称", width=150)
    private String cUserName;

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

    @ApiModelProperty(value = "sys_message 主键")
    @ExcelField(value = "sys_message 主键", width=150)
    private String messageId;

    @ApiModelProperty(value = "发送人、接收人、抄送人")
    @ExcelField(value = "发送人、接收人、抄送人", width=150)
    private String userType;

    @ApiModelProperty(value = "用户登录名")
    @ExcelField(value = "用户登录名", width=150)
    private String userId;

    @ApiModelProperty(value = "用户名称")
    @ExcelField(value = "用户名称", width=150)
    private String userName;

    @ApiModelProperty(value = "已读标记（Y-已读 N-未读）")
    @ExcelField(value = "已读标记（Y-已读 N-未读）", width=150)
    private String readFlag;

    @ApiModelProperty(value = "采集标记（Y-已读 N-未读）")
    @ExcelField(value = "采集标记（Y-已读 N-未读）", width=150)
    private String collectFlag;



}