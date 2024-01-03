package com.wakedt.visual.client.businessscene.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新增业务场景版本
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "新增业务场景版本")
public class BusinessSceneVersionCreateDTO {

    @ApiModelProperty(value = "所属业务场景ID")
    private Long businessSceneId;

    @ApiModelProperty(value = "起始版本号ID")
    private Long startVersionId;

    @ApiModelProperty(value = "当前版本号")
    private String currentVersion;

    @ApiModelProperty(value = "描述信息")
    private String description;
}