package com.wakedt.visual.client.businessservice.secondarydevelopment.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务场景版本基本信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "业务场景版本基本信息")
public class BusinessScenarioVersionBaseInfoDTO extends BaseDTO {

    @ApiModelProperty(value = "业务场景版本的唯一标识")
    private Long id;

    @ApiModelProperty(value = "起始版本号")
    private String startVersion;

    @ApiModelProperty(value = "当前版本号")
    private String currentVersion;

    @ApiModelProperty(value = "版本描述信息")
    private String description;

    @ApiModelProperty(value = "版本状态")
    private Integer state;

    @ApiModelProperty(value = "业务场景信息")
    private BusinessScenarioDTO businessScenarioDTO;

}