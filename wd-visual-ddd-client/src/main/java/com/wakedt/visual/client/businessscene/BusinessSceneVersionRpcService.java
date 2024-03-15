package com.wakedt.visual.client.businessscene;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.businessscene.dto.*;
import com.wakedt.visual.client.businessscene.query.BusinessSceneVersionDetailQuery;
import com.wakedt.visual.client.businessscene.query.BusinessSceneVersionPageQuery;

import java.util.List;

/**
 * 业务场景版本-聚合根-RPC能力接口
 *
 * @author zhuxueliang
 */
public interface BusinessSceneVersionRpcService {

    /**
     * 新增业务场景版本
     */
    ResultDTO<Long> businessSceneVersionCreate(BusinessSceneVersionCreateDTO businessSceneVersionCreateDto);

    /**
    * 更新业务场景版本
    */
    ResultDTO<Boolean> businessSceneVersionUpdate(BusinessSceneVersionUpdateDTO businessSceneVersionUpdateDto);

    /**
    * 删除业务场景版本
    */
    ResultDTO<Boolean> businessSceneVersionRemove(BusinessSceneVersionRemoveDTO businessSceneVersionRemoveDto);

    /**
    * 发布业务场景版本
    */
    ResultDTO<Boolean> businessSceneVersionPblish(BusinessSceneVersionPublishDTO businessSceneVersionPblishDto);

    /**
    * 更新业务场景DSL
    */
    ResultDTO<Boolean> businessSceneDSLUpdate(BusinessSceneDSLUpdateDTO businessSceneDSLUpdateDto);

    /**
     * 查询业务场景版本详情
     */
    ResultDTO<BusinessSceneVersionDTO> businessSceneVersionDetailQuery(BusinessSceneVersionDetailQuery query);

    /**
     * 查询业务场景版本简介
     */
    ResultDTO<BusinessSceneVersionDTO> businessSceneVersionSimpleQuery(BusinessSceneVersionDetailQuery query);

    /**
     * 分页查询业务场景版本信息
     */
    ResultDTO<List<BusinessSceneVersionDTO>> businessSceneVersionPageQuery(BusinessSceneVersionPageQuery pageQuery);

}