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
 * FileExport对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="File对象", description="文件")
@Excel("File导出")
public class FileExport{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "文件Id")
    @ExcelField(value = "文件Id", width=150)
    private String fileId;

    @ApiModelProperty(value = "删除标记（0：正常，1：删除）")
    @ExcelField(value = "删除标记（0：正常，1：删除）", width=150)
    private Integer delFlag;

    @ApiModelProperty(value = "排序字段（用户可以手动操作数据顺序时用到）")
    @ExcelField(value = "排序字段（用户可以手动操作数据顺序时用到）", width=150)
    private Integer dataOrder;

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

    @ApiModelProperty(value = "目录Id")
    @ExcelField(value = "目录Id", width=150)
    private String directoryId;

    @ApiModelProperty(value = "业务类型")
    @ExcelField(value = "业务类型", width=150)
    private String businessType;

    @ApiModelProperty(value = "业务ID")
    @ExcelField(value = "业务ID", width=150)
    private String businessId;

    @ApiModelProperty(value = "文件名")
    @ExcelField(value = "文件名", width=150)
    private String fileName;

    @ApiModelProperty(value = "文件编码")
    @ExcelField(value = "文件编码", width=150)
    private String fileCode;

    @ApiModelProperty(value = "文件大小(K)")
    @ExcelField(value = "文件大小(K)", width=150)
    private Float fileSize;

    @ApiModelProperty(value = "文件类别（业务、消息……）")
    @ExcelField(value = "文件类别（业务、消息……）", width=150)
    private String fileKind;

    @ApiModelProperty(value = "文件类型(docx,xlsx,jpb)")
    @ExcelField(value = "文件类型(docx,xlsx,jpb)", width=150)
    private String fileType;

    @ApiModelProperty(value = "存储")
    @ExcelField(value = "存储", width=150)
    private String fileStore;

    @ApiModelProperty(value = "转换后路径")
    @ExcelField(value = "转换后路径", width=150)
    private String fileConverterStore;

    @ApiModelProperty(value = "备注")
    @ExcelField(value = "备注", width=150)
    private String fileComment;



}