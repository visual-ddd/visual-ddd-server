package com.wakedt.visual.domain.organization.team.create;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建团队-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "创建团队指令")
public class TeamCreateCmd {

    /** 团队名称 */
    private String name;

    /** 描述信息 */
    private String description;

    /** 所属组织ID */
    private Long organizationId;

    /** 团队管理员ID */
    private Long teamManagerId;
}