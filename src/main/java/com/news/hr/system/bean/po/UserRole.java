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
 * UserRole对象
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
@TableName("sys_user_role")
@ApiModel(value = "UserRole对象", description = "用户角色关联表")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID=1L;

    @TableId(value = "user_role_id", type = IdType.UUID)
        private String userRoleId;

    @TableField("user_id")
    private String userId;

    @TableField("role_id")
    private String roleId;


    @Override
    protected Serializable pkVal(){
            return this.userRoleId;
        }

}