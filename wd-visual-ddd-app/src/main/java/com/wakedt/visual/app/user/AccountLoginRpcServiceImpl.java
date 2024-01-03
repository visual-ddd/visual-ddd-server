package com.wakedt.visual.app.user;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.organization.view.OrganizationInfoByAccountIdQueryExe;
import com.wakedt.visual.app.organization.view.TeamInfoByAccountIdQueryExe;
import com.wakedt.visual.app.user.assembler.AccountLoginDTOConvert;
import com.wakedt.visual.app.user.view.AccountDetailQueryExe;
import com.wakedt.visual.client.organization.dto.OrganizationDTO;
import com.wakedt.visual.client.organization.dto.TeamDTO;
import com.wakedt.visual.client.user.AccountLoginRpcService;
import com.wakedt.visual.client.user.dto.*;
import com.wakedt.visual.client.user.query.AccountDetailQuery;
import com.wakedt.visual.domain.common.constant.VisualConstant;
import com.wakedt.visual.domain.user.account.login.AccountLoginCmd;
import com.wakedt.visual.domain.user.account.login.AccountLoginCmdHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WangChenSheng
 * date 2022/12/30 10:30
 */
@Service
public class AccountLoginRpcServiceImpl implements AccountLoginRpcService {

    @Resource
    private AccountLoginCmdHandler accountLoginCmdHandler;

    @Resource
    private AccountDetailQueryExe accountDetailQueryExe;

    @Resource
    private TeamInfoByAccountIdQueryExe teamInfoByAccountIdQueryExe;

    @Resource
    private OrganizationInfoByAccountIdQueryExe organizationInfoByAccountIdQueryExe;

    @Override
    public ResultDTO<AccountDTO> login(AccountLoginDTO accountLoginDTO) {
        AccountLoginCmd accountLoginCmd = AccountLoginDTOConvert.INSTANCE.dto2Do(accountLoginDTO);
        Long id = accountLoginCmdHandler.handle(accountLoginCmd);

        AccountDetailQuery query = new AccountDetailQuery();
        query.setId(id);
        return accountDetailQueryExe.execute(query);
    }

    @Override
    public ResultDTO<AccountRoleDTO> buildAccountRoleInfo(AccountInfo accountInfo) {
        AccountRoleDTO accountRoleDTO = new AccountRoleDTO();
        Long accountId = accountInfo.getId();
        accountRoleDTO.setId(accountId);
        accountRoleDTO.setIsSysAdmin(VisualConstant.DEFAULT_SYS_ADMIN_ID.equals(accountId));

        // 获取用户所属团队信息和组织信息列表
        List<TeamDTO> teamDTOList = teamInfoByAccountIdQueryExe.execute(accountId).getData();
        List<OrganizationDTO> organizationDTOList = organizationInfoByAccountIdQueryExe.execute(accountId).getData();

        List<AccountTeamInfo> accountTeamInfoList = new ArrayList<>(teamDTOList.size());
        List<AccountOrganizationInfo> accountOrganizationInfoList = new ArrayList<>(organizationDTOList.size());

        // 遍历团队信息并添加到 accountTeamInfoList
        for (TeamDTO teamDTO : teamDTOList) {
            AccountTeamInfo accountTeamInfo = new AccountTeamInfo();
            accountTeamInfo.setTeamDTO(teamDTO);
            accountTeamInfo.setIsTeamAdmin(accountId.equals(teamDTO.getTeamManagerId()));
            accountTeamInfoList.add(accountTeamInfo);
        }

        // 遍历组织信息并添加到 accountOrganizationInfoList
        for (OrganizationDTO organizationDTO : organizationDTOList) {
            AccountOrganizationInfo accountOrganizationInfo = new AccountOrganizationInfo();
            accountOrganizationInfo.setOrganizationDTO(organizationDTO);
            accountOrganizationInfo.setIsOrganizationAdmin(accountId.equals(organizationDTO.getOrganizationManagerId()));
            accountOrganizationInfoList.add(accountOrganizationInfo);
        }

        accountRoleDTO.setAccountTeamInfoList(accountTeamInfoList);
        accountRoleDTO.setAccountOrganizationInfoList(accountOrganizationInfoList);

        return ResultDTO.success(accountRoleDTO);
    }

}
