package com.wakedt.visual.client.businessservice.secondarydevelopment.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 应用信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "应用信息")
public class ApplicationDTO extends BaseDTO {

    @ApiModelProperty(value = "应用的唯一标识")
    private Long id;

    @ApiModelProperty(value = "所属团队ID")
    private Long teamId;

    @ApiModelProperty(value = "包名")
    private String packageName;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标识符")
    private String identity;

    @ApiModelProperty(value = "描述信息")
    private String description;

}