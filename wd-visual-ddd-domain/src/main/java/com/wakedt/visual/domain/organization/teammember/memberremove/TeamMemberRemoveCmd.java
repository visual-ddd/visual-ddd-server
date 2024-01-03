package com.wakedt.visual.domain.organization.teammember.memberremove;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除团队成员-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "删除团队成员指令")
public class TeamMemberRemoveCmd {

    /** 主键 */
    private Long id;

}