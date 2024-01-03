package com.wakedt.visual.client.businessscene.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 删除业务场景版本
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "删除业务场景版本")
public class BusinessSceneVersionRemoveDTO {

    @ApiModelProperty(value = "主键")
    private Long id;
}