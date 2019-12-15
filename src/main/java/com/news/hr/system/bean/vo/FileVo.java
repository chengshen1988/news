package com.news.hr.system.bean.vo;

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
 * FileVO对象
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
public class FileVo{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "文件Id")
    private String fileId;

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

    @ApiModelProperty(value = "目录Id")
    private String directoryId;

    @ApiModelProperty(value = "业务类型")
    private String businessType;

    @ApiModelProperty(value = "业务ID")
    private String businessId;

    @ApiModelProperty(value = "文件名")
    private String fileName;

    @ApiModelProperty(value = "文件编码")
    private String fileCode;

    @ApiModelProperty(value = "文件大小(K)")
    private Float fileSize;

    @ApiModelProperty(value = "文件类别（业务、消息……）")
    private String fileKind;

    @ApiModelProperty(value = "文件类型(docx,xlsx,jpb)")
    private String fileType;

    @ApiModelProperty(value = "存储")
    private String fileStore;

    @ApiModelProperty(value = "转换后路径")
    private String fileConverterStore;

    @ApiModelProperty(value = "备注")
    private String fileComment;



}