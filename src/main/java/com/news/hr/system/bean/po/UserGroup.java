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


import java.time.LocalDate;
/**
 * <p>
 * UserGroup对象
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
@TableName("sys_user_group")
@ApiModel(value = "UserGroup对象", description = "")
public class UserGroup extends Model<UserGroup> {

    private static final long serialVersionUID=1L;

    @TableId(value = "user_group_id", type = IdType.ASSIGN_UUID)
        private String userGroupId;

    @ApiModelProperty(value = "用户登录名")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "分组Id")
    @TableField("group_id")
    private String groupId;


    @Override
    protected Serializable pkVal(){
            return this.userGroupId;
        }

}