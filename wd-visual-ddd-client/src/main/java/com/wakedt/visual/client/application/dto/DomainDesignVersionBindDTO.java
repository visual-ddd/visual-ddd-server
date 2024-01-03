package com.wakedt.visual.client.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 关联业务域版本
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "关联业务域版本")
public class DomainDesignVersionBindDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "业务域版本ID列表")
    private List<Long> domainDesignVersionIds;
}