package com.news.hr.business.bean.dto;

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
 * LinkManageExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="LinkManage对象", description="链接管理")
@Excel("LinkManage导出")
public class LinkManageExport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "链接主键")
    @ExcelField(value = "链接主键", width=150)
    private Integer linkManageId;

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

    @ApiModelProperty(value = "链接名称")
    @ExcelField(value = "链接名称", width=150)
    private String linkName;

    @ApiModelProperty(value = "链接地址")
    @ExcelField(value = "链接地址", width=150)
    private String linkUrl;

    @ApiModelProperty(value = "所属分类")
    @ExcelField(value = "所属分类", width=150)
    private String linkCategory;

    @ApiModelProperty(value = "所属图片")
    @ExcelField(value = "所属图片", width=150)
    private String imageUrl;



}