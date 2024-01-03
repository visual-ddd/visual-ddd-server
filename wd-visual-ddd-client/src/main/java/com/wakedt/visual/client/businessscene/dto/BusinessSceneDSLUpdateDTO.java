package com.wakedt.visual.client.businessscene.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 更新业务场景DSL
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "更新业务场景DSL")
public class BusinessSceneDSLUpdateDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "业务场景DSL")
    private String dsl;

    @ApiModelProperty(value = "图形DSL")
    private String graphDsl;
}