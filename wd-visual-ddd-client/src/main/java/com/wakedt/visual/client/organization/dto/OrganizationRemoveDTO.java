package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 删除组织
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "删除组织")
public class OrganizationRemoveDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

}