package com.news.hr.business.bean.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import java.io.Serializable;


/**
 * <p>
 * ContentVO对象
 * </p>
 *
 * @author Chen Seen
 * @since 2019-12-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Content对象", description="文档内容")
public class ContentForm{

    private static final long serialVersionUID = 1L;
    private Integer contentId;

    private String contentInfo;



}