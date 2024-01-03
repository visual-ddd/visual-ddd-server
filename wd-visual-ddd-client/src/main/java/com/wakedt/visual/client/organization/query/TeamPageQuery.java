package com.wakedt.visual.client.organization.query;

import com.wakedata.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页查询团队信息-分页查询对象
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "分页查询团队信息分页查询对象")
public class TeamPageQuery extends PageQuery {

    @ApiModelProperty(value = "组织id")
    private String organizationId;

    @ApiModelProperty(value = "团队名称")
    private String name;

}