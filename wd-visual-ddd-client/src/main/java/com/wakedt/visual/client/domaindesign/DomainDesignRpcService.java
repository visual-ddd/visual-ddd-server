package com.wakedt.visual.client.domaindesign;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignCreateDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignRemoveDTO;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignUpdateDTO;
import com.wakedt.visual.client.domaindesign.query.DomainDesignDetailQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignListQuery;
import com.wakedt.visual.client.domaindesign.query.DomainDesignPageQuery;

import java.util.List;

/**
 * 业务域-聚合根-RPC能力接口
 *
 * @author zhuxueliang
 */
public interface DomainDesignRpcService {

    /**
     * 新增业务域
     *
     * @param domainDesignCreateDto 新增业务域参数
     * @return true/false
     */
    ResultDTO<Long> domainDesignCreate(DomainDesignCreateDTO domainDesignCreateDto);

    /**
     * 更新业务域
     */
    ResultDTO<Boolean> domainDesignUpdate(DomainDesignUpdateDTO domainDesignUpdateDto);

    /**
     * 删除业务域
     */
    ResultDTO<Boolean> domainDesignRemove(DomainDesignRemoveDTO domainDesignRemoveDto);

    /**
     * 查询业务域详情
     */
    ResultDTO<DomainDesignDTO> domainDesignDetailQuery(DomainDesignDetailQuery query);

    /**
     * 查询业务域列表详情
     */
    ResultDTO<List<DomainDesignDTO>> domainDesignListQuery(DomainDesignListQuery query);

    /**
     * 分页查询业务域信息
     */
    ResultDTO<List<DomainDesignDTO>> domainDesignPageQuery(DomainDesignPageQuery pageQuery);
}