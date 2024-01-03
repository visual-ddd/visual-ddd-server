package com.wakedt.visual.domain.organization.team.remove;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除团队-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "删除团队指令")
public class TeamRemoveCmd {

    /** 主键 */
    private Long id;

}