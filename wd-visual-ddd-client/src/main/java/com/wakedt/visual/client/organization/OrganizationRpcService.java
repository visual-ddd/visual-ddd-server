package com.wakedt.visual.client.organization;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.organization.dto.*;
import com.wakedt.visual.client.organization.query.OrganizationDetailQuery;
import com.wakedt.visual.client.organization.query.OrganizationPageQuery;

import java.util.List;

/**
 * 组织-聚合根-RPC能力接口
 *
 * @author zhuxueliang
 */
public interface OrganizationRpcService {

    /**
    * 创建组织
    */
    ResultDTO<Boolean> organizationCreate(OrganizationCreateDTO organizationCreateDto);

    /**
    * 更新组织信息
    */
    ResultDTO<Boolean> organizationUpdate(OrganizationUpdateDTO organizationUpdateDto);

    /**
    * 删除组织
    */
    ResultDTO<Boolean> organizationRemove(OrganizationRemoveDTO organizationRemoveDto);

    /**
     * 批量删除组织
     */
    ResultDTO<Boolean> organizationBatchRemove(OrganizationBatchRemoveDTO dto);

    /**
    * 绑定组织管理员
    */
    ResultDTO<Boolean> organizationManagerBind(OrganizationManagerBindDTO organizationManagerBindDto);

    /**
    * 解绑组织管理员
    */
    ResultDTO<Boolean> organizationManagerUnbind(OrganizationManagerUnbindDTO organizationManagerUnbindDto);

    /**
     * 分页查询组织信息
     */
    ResultDTO<List<OrganizationDTO>> organizationPageQuery(OrganizationPageQuery pageQuery);

    /**
     * 查询组织详情
     */
    ResultDTO<OrganizationDTO> organizationDetailQuery(OrganizationDetailQuery query);
}