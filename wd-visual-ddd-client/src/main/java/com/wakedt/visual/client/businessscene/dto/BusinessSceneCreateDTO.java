package com.wakedt.visual.client.businessscene.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新增业务场景
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "新增业务场景")
public class BusinessSceneCreateDTO {

    @ApiModelProperty(value = "所属团队ID")
    private Long teamId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标识符")
    private String identity;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "起始版本号")
    private String startVersion;
}