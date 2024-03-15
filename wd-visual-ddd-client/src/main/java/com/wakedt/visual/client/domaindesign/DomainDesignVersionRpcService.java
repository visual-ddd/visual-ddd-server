package com.wakedt.visual.client.domaindesign;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.domaindesign.dto.*;
import com.wakedt.visual.client.domaindesign.query.DomainDesignVersionDetailQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignVersionPageQuery;

import java.util.List;

/**
 * 业务域版本-聚合根-RPC能力接口
 *
 * @author zhuxueliang
 */
public interface DomainDesignVersionRpcService {

    /**
     * 新增业务域版本
     *
     * @param domainDesignVersionCreateDto 新增入参
     * @return id
     */
    ResultDTO<Long> domainDesignVersionCreate(DomainDesignVersionCreateDTO domainDesignVersionCreateDto);

    /**
     * 更新业务域版本
     *
     * @param domainDesignVersionUpdateDto 更新入参
     * @return true/false
     */
    ResultDTO<Boolean> domainDesignVersionUpdate(DomainDesignVersionUpdateDTO domainDesignVersionUpdateDto);

    /**
     * 删除业务域版本
     *
     * @param domainDesignVersionRemoveDto 删除入参
     * @return true/false
     */
    ResultDTO<Boolean> domainDesignVersionRemove(DomainDesignVersionRemoveDTO domainDesignVersionRemoveDto);

    /**
     * 发布业务域版本
     *
     * @param domainDesignVersionPublishDto 发布业务域版本参数
     * @return true/false
     */
    ResultDTO<Boolean> domainDesignVersionPublish(DomainDesignVersionPublishDTO domainDesignVersionPublishDto);

    /**
     * 更新业务域DSL
     *
     * @param domainDesignDslUpdate 更新业务域DSL参数
     * @return true/false
     */
    ResultDTO<Boolean> domainDesignDslUpdate(DomainDesignDSLUpdateDTO domainDesignDslUpdate);

    /**
     * 查询业务域版本详情
     *
     * @param query 查询条件参数
     * @return DomainDesignVersionDTO
     */
    ResultDTO<DomainDesignVersionDTO> domainDesignVersionDetailQuery(DomainDesignVersionDetailQuery query);

    /**
     * 查询业务域版本简介
     *
     * @param query 查询条件参数
     * @return DomainDesignVersionDTO
     */
    ResultDTO<DomainDesignVersionDTO> domainDesignVersionSimpleQuery(DomainDesignVersionDetailQuery query);

    /**
     * 分页查询业务域版本信息
     *
     * @param pageQuery 查询条件
     * @return true/false
     */
    ResultDTO<List<DomainDesignVersionDTO>> domainDesignVersionPageQuery(DomainDesignVersionPageQuery pageQuery);
}