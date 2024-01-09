package com.wakedt.visual.app.organization.view;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.organization.assembler.OrganizationDTO2DOConvert;
import com.wakedt.visual.client.organization.dto.OrganizationDTO;
import com.wakedt.visual.client.organization.query.OrganizationPageQuery;
import com.wakedt.visual.infrastructure.organization.repository.mapper.OrganizationMapper;
import com.wakedt.visual.infrastructure.organization.repository.model.OrganizationDO;
import com.wakedt.visual.infrastructure.user.repository.mapper.AccountMapper;
import com.wakedt.visual.infrastructure.user.repository.model.AccountDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 分页查询组织信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class OrganizationPageQueryExe {

    @Resource
    private OrganizationMapper organizationMapper;
    @Resource
    private AccountMapper accountMapper;

    public PageResultDTO<List<OrganizationDTO>> execute(OrganizationPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getPageSize());

        List<OrganizationDO> organizationDOList = organizationMapper.organizationPageQuery(pageQuery);
        PageInfo<OrganizationDO> pageInfo = new PageInfo<>(organizationDOList);
        List<OrganizationDTO> organizationDTOList = OrganizationDTO2DOConvert.INSTANCE.doList2DtoList(pageInfo.getList());
        organizationDTOList.forEach(this::putManagerName);

        PageResultDTO<List<OrganizationDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(organizationDTOList);
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }

    private void putManagerName(OrganizationDTO organizationDTO) {
        Long organizationManagerId = organizationDTO.getOrganizationManagerId();
        AccountDO accountDO = accountMapper.selectById(organizationManagerId);
        String userName = Optional.ofNullable(accountDO).map(AccountDO::getUserName).orElse(StringUtils.EMPTY);
        organizationDTO.setOrganizationManagerName(userName);
    }

}
