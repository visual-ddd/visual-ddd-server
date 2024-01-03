package com.wakedt.visual.client.organization.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 解绑团队成员职位
 *
 * @author zhuxueliang
 */
@Data
@ApiModel(value = "解绑团队成员职位")
public class TeamMemberRoleUnbindDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "成员类型（1-产品经理，2-架构师， 3-开发者）")
    private List<Integer> memberTypeList;

}