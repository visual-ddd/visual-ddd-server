package com.wakedt.visual.client.businessservice.secondarydevelopment.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务场景信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "业务场景信息")
public class BusinessScenarioDTO extends BaseDTO {

    @ApiModelProperty(value = "业务场景的唯一标识")
    private Long id;

    @ApiModelProperty(value = "所属团队ID")
    private Long teamId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标识符")
    private String identity;

    @ApiModelProperty(value = "描述信息")
    private String description;

}