package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 解绑组织管理员
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "解绑组织管理员")
public class OrganizationManagerUnbindDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

}