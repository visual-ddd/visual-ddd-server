package com.wakedt.visual.client.domaindesign.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务域版本信息
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "业务域版本信息")
public class DomainDesignVersionDTO extends BaseDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "所属业务域ID")
    private Long domainDesignId;

    @ApiModelProperty(value = "所属业务域")
    private DomainDesignDTO domainDesignDTO;

    @ApiModelProperty(value = "起始版本号")
    private String startVersion;

    @ApiModelProperty(value = "当前版本号")
    private String currentVersion;

    @ApiModelProperty(value = "业务域DSL")
    private String domainDesignDsl;

    @ApiModelProperty(value = "图形DSL")
    private String graphDsl;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "版本状态")
    private Integer state;
}