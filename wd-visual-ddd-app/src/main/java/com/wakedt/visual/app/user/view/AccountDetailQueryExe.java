package com.wakedt.visual.app.user.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.user.assembler.AccountDTO2DOConvert;
import com.wakedt.visual.client.user.dto.AccountDTO;
import com.wakedt.visual.client.user.query.AccountDetailQuery;
import com.wakedt.visual.domain.common.constant.MsgCodeEnum;
import com.wakedt.visual.domain.common.constant.VisualException;
import com.wakedt.visual.infrastructure.user.repository.mapper.AccountMapper;
import com.wakedt.visual.infrastructure.user.repository.model.AccountDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 查询用户账号信息详情-查询器
 *
 * @author zhuxueliang
 */
@Component
public class AccountDetailQueryExe {

    @Resource
    private AccountMapper accountMapper;

    public ResultDTO<AccountDTO> execute(AccountDetailQuery query) {
        AccountDO accountDO = Optional.ofNullable(accountMapper.accountDetailQuery(query))
                .orElseThrow(() -> new VisualException(MsgCodeEnum.NO_FIND_RESOURCE));
        AccountDTO accountDTO = AccountDTO2DOConvert.INSTANCE.do2Dto(accountDO);
        return ResultDTO.success(accountDTO);
    }
}
