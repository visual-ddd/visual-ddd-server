package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 添加团队成员
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "添加团队成员")
public class TeamMemberAddDTO {

    @ApiModelProperty(value = "成员账号ID")
    private Long accountId;

    @ApiModelProperty(value = "团队ID")
    private Long teamId;

    @ApiModelProperty(value = "成员类型（1-产品经理，2-架构师， 3-开发者）")
    private List<Integer> memberTypeList;
}