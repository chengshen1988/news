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


import java.time.LocalDate;
/**
 * <p>
 * File对象
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
@TableName("sys_file")
@ApiModel(value = "File对象", description = "文件")
public class File extends Model<File> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "文件Id")
    @TableId(value = "file_id", type = IdType.ASSIGN_UUID)
        private String fileId;

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

    @ApiModelProperty(value = "目录Id")
    @TableField("directory_id")
    private String directoryId;

    @ApiModelProperty(value = "业务类型")
    @TableField("business_type")
    private String businessType;

    @ApiModelProperty(value = "业务ID")
    @TableField("business_id")
    private String businessId;

    @ApiModelProperty(value = "文件名")
    @TableField("file_name")
    private String fileName;

    @ApiModelProperty(value = "文件编码")
    @TableField("file_code")
    private String fileCode;

    @ApiModelProperty(value = "文件大小(K)")
    @TableField("file_size")
    private Float fileSize;

    @ApiModelProperty(value = "文件类别（业务、消息……）")
    @TableField("file_kind")
    private String fileKind;

    @ApiModelProperty(value = "文件类型(docx,xlsx,jpb)")
    @TableField("file_type")
    private String fileType;

    @ApiModelProperty(value = "存储")
    @TableField("file_store")
    private String fileStore;

    @ApiModelProperty(value = "转换后路径")
    @TableField("file_converter_store")
    private String fileConverterStore;

    @ApiModelProperty(value = "备注")
    @TableField("file_comment")
    private String fileComment;


    @Override
    protected Serializable pkVal(){
            return this.fileId;
        }

}