package com.wakedt.visual.client.domaindesign.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 新增业务域
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "新增业务域")
public class DomainDesignCreateDTO {

    @ApiModelProperty(value = "所属团队ID")
    @NotNull(message = "所属团队id不能为空")
    private Long teamId;

    @ApiModelProperty(value = "名称")
    @NotBlank(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "标识符")
    @NotBlank(message = "标识符不能为空")
    private String identity;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "起始版本号")
    @NotBlank(message = "起始版本号不能为空")
    private String startVersion;
}