package com.wakedt.visual.app.user.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.user.assembler.AccountDTO2DOConvert;
import com.wakedt.visual.client.user.dto.AccountDTO;
import com.wakedt.visual.client.user.query.AccountPageQuery;
import com.wakedt.visual.infrastructure.user.repository.mapper.AccountMapper;
import com.wakedt.visual.infrastructure.user.repository.model.AccountDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分页查询用户账号信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class AccountPageQueryExe {

    @Resource
    private AccountMapper accountMapper;

    public PageResultDTO<List<AccountDTO>> execute(AccountPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(),pageQuery.getPageSize());

        List<AccountDO> accountDoList = accountMapper.accountPageQuery(pageQuery);
        PageInfo<AccountDO> pageInfo = new PageInfo<>(accountDoList);
        List<AccountDTO> accountDTOList = AccountDTO2DOConvert.INSTANCE.doList2DtoList(pageInfo.getList());

        PageResultDTO<List<AccountDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(accountDTOList);
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }
}
