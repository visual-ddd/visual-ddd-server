package com.wakedt.visual.domain.organization.teammember.memberadd;

import com.wakedt.visual.domain.organization.teammember.MemberType;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 添加团队成员-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "添加团队成员指令")
public class TeamMemberAddCmd {

    /** 成员账号ID */
    private Long accountId;

    /** 团队ID */
    private Long teamId;

    /** 成员类型（1-产品经理，2-架构师， 3-开发者） */
    private List<MemberType> memberTypeList;
}