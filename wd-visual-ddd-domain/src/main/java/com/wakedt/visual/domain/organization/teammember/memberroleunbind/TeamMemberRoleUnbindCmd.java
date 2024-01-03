package com.wakedt.visual.domain.organization.teammember.memberroleunbind;

import com.wakedt.visual.domain.organization.teammember.MemberType;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 解绑团队成员职位-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "解绑团队成员职位指令")
public class TeamMemberRoleUnbindCmd {

    /** 主键 */
    private Long id;

    /** 成员类型（1-产品经理，2-架构师， 3-开发者） */
    private List<MemberType> memberTypeList;

}