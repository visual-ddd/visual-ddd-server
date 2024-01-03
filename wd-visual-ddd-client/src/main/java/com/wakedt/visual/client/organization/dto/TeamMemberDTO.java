package com.wakedt.visual.client.organization.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 团队成员信息
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "团队成员信息")
public class TeamMemberDTO extends BaseDTO {

    @ApiModelProperty(value = "所属团队")
    private Long teamId;

    @ApiModelProperty(value = "成员账号ID")
    private Long accountId;

    @ApiModelProperty(value = "成员名称")
    private String teamMemberName;

    @ApiModelProperty(value = "成员账号")
    private String accountNo;

    @ApiModelProperty(value = "成员类型（1-产品经理，2-架构师， 3-开发者）")
    private List<Integer> memberTypeList;

}