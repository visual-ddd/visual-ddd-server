package com.wakedt.visual.domain.user.account.create;

import com.wakedt.visual.domain.organization.organization.Organization;
import com.wakedt.visual.domain.organization.organization.create.OrganizationCreateCmd;
import com.wakedt.visual.domain.organization.organization.create.OrganizationCreateCmdHandler;
import com.wakedt.visual.domain.organization.team.create.TeamCreateCmd;
import com.wakedt.visual.domain.organization.team.create.TeamCreateCmdHandler;
import com.wakedt.visual.domain.user.account.Account;
import com.wakedt.visual.domain.user.account.AccountFactory;
import com.wakedt.visual.domain.user.account.AccountRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 创建账号-指令处理器
 *
 * @author zhuxueliang
 */
@Component
public class AccountCreateCmdHandler {

    @Resource
    private AccountRepository repository;
    @Resource
    private AccountFactory factory;
    @Resource
    private TeamCreateCmdHandler teamCreateCmdHandler;
    @Resource
    private OrganizationCreateCmdHandler organizationCreateCmdHandler;

    public static final String SYSTEM_GLOBAL_ORG = "系统公共组织";

    @Transactional(rollbackFor = Exception.class)
    public void handle(AccountCreateCmd createCmd) {
        Account account = factory.getInstance(createCmd);
        repository.isAccountExistsOrError(createCmd.getAccountNo());
        Account newAccount = repository.save(account);

        // 为新用户初始化私人空间
        initPersonalSpace(newAccount);

//        DomainEventPublisher.getInstance().postAfterCommit(new AccountCreateCmdEvent(createCmd));
    }

    private void initPersonalSpace(Account account) {
        // 获取公共组织
        Organization organization = repository.getOrganizationByIdentity(SYSTEM_GLOBAL_ORG);
        Long organizationId;
        if (organization == null) {
            // 公共组织第一次初始化
            OrganizationCreateCmd createCmd = new OrganizationCreateCmd();
            createCmd.setName(SYSTEM_GLOBAL_ORG);
            createCmd.setDescription("系统创建的公共组织，用于维护每个用户的私人空间，只对系统管理员可见");
            createCmd.setOrganizationManagerId(1L);
            organizationId = organizationCreateCmdHandler.handle(createCmd);
        } else {
            // 公共组织已创建
            organizationId = organization.getId();
        }

        // 初始化私人空间
        TeamCreateCmd teamCreateCmd = new TeamCreateCmd();
        teamCreateCmd.setName(String.format("%s 的个人空间", account.getAccountNo())); // 手机号保证团队名称唯一，后期考虑使用编号唯一
        teamCreateCmd.setDescription("系统初始化的个人空间");
        teamCreateCmd.setOrganizationId(organizationId);
        teamCreateCmd.setTeamManagerId(account.getId());
        teamCreateCmdHandler.handle(teamCreateCmd);
    }
}