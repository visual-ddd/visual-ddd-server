package com.wakedt.visual.client.businessscene.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 发布业务场景版本
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "发布业务场景版本")
public class BusinessSceneVersionPublishDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "描述信息")
    private String description;
}