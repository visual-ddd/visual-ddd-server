package com.wakedt.visual.domain.organization.team.managerbind;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 绑定团队管理员-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "绑定团队管理员指令")
public class TeamManagerBindCmd {

    /** 主键 */
    private Long id;

    /** 团队管理员ID */
    private Long teamManagerId;

}