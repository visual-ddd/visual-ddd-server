package com.wakedt.visual.domain.organization.team.update;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新团队信息-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新团队信息指令")
public class TeamUpdateCmd {

    /** 主键 */
    private Long id;

    /** 团队名称 */
    private String name;

    /** 描述信息 */
    private String description;

    /** 团队管理员ID */
    private Long teamManagerId;
}