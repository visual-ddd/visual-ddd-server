package com.wakedt.visual.client.user.query;

import com.wakedata.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页查询用户账号信息-分页查询对象
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "分页查询用户账号信息分页查询对象")
public class AccountPageQuery extends PageQuery {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "所属组织")
    private Long organizationId;

    @ApiModelProperty(value = "所属团队")
    private Long teamId;

}