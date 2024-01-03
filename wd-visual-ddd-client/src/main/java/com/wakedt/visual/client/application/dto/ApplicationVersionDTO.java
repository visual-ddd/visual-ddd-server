package com.wakedt.visual.client.application.dto;

import com.wakedata.common.core.base.BaseDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneVersionDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignVersionDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 应用版本信息
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "应用版本信息")
public class ApplicationVersionDTO extends BaseDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "所属应用ID")
    private Long applicationId;

    @ApiModelProperty(value = "起始版本号")
    private String startVersion;

    @ApiModelProperty(value = "当前版本号")
    private String currentVersion;

    @ApiModelProperty(value = "业务场景版本ID列表")
    private List<Long> businessSceneVersionIds;

    @ApiModelProperty(value = "业务场景信息列表")
    private List<BusinessSceneVersionDTO> businessSceneVersionDTOList;

    @ApiModelProperty(value = "业务域版本ID列表")
    private List<Long> domainDesignVersionIds;

    @ApiModelProperty(value = "业务域版本信息列表")
    private List<DomainDesignVersionDTO> domainDesignVersionDTOList;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "版本状态")
    private Integer state;
}