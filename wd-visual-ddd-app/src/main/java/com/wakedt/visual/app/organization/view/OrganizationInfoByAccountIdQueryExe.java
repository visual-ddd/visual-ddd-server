package com.wakedt.visual.app.organization.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.organization.assembler.OrganizationDTO2DOConvert;
import com.wakedt.visual.client.organization.dto.OrganizationDTO;
import com.wakedt.visual.infrastructure.organization.repository.mapper.OrganizationMapper;
import com.wakedt.visual.infrastructure.organization.repository.model.OrganizationDO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分页查询团队信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class OrganizationInfoByAccountIdQueryExe {

    @Resource
    private OrganizationMapper organizationMapper;

    @Cacheable(value = "organizationListCache", key = "#accountId")
    public ResultDTO<List<OrganizationDTO>> execute(Long accountId) {
        List<OrganizationDO> organizationDOList = organizationMapper.organizationInfoByAccountId(accountId);
        return ResultDTO.success(OrganizationDTO2DOConvert.INSTANCE.doList2DtoList(organizationDOList));
    }
}
