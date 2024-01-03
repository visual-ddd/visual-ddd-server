package com.wakedt.visual.app.organization.view;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.organization.assembler.OrganizationDTO2DOConvert;
import com.wakedt.visual.client.organization.dto.OrganizationDTO;
import com.wakedt.visual.client.organization.query.OrganizationDetailQuery;
import com.wakedt.visual.domain.common.constant.MsgCodeEnum;
import com.wakedt.visual.domain.common.constant.VisualException;
import com.wakedt.visual.infrastructure.organization.repository.mapper.OrganizationMapper;
import com.wakedt.visual.infrastructure.organization.repository.model.OrganizationDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 查询组织详情信息-查询器
 *
 * @author zhuxueliang
 */
@Component
public class OrganizationDetailQueryExe {

    @Resource
    private OrganizationMapper organizationMapper;

    public ResultDTO<OrganizationDTO> execute(OrganizationDetailQuery query) {
        OrganizationDO organizationDO = Optional.ofNullable(organizationMapper.organizationDetailQuery(query))
                .orElseThrow(() -> new VisualException(MsgCodeEnum.NO_FIND_RESOURCE));
        OrganizationDTO organizationDTO = OrganizationDTO2DOConvert.INSTANCE.do2Dto(organizationDO);
        return PageResultDTO.success(organizationDTO);
    }
}
