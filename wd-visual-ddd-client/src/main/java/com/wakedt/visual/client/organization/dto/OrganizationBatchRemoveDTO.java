package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 批量删除组织
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "批量删除组织")
public class OrganizationBatchRemoveDTO {

    @ApiModelProperty(value = "主键列表")
    private List<Long> idList;
}
