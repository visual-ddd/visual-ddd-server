package com.wakedt.visual.domain.organization.team.managerunbind;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 解绑团队管理员-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "解绑团队管理员指令")
public class TeamManagerUnbindCmd {

    /** 主键 */
    private Long id;

}