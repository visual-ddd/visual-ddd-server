package com.wakedt.visual.client.businessscene;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneCreateDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneRemoveDTO;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneUpdateDTO;
import com.wakedt.visual.client.businessscene.query.BusinessSceneDetailQuery;
import com.wakedt.visual.client.businessscene.query.BusinessSceneListQuery;
import com.wakedt.visual.client.businessscene.query.BusinessScenePageQuery;

import java.util.List;

/**
 * 业务场景-聚合根-RPC能力接口
 *
 * @author zhuxueliang
 */
public interface BusinessSceneRpcService {

    /**
    * 新增业务场景
    */
    ResultDTO<Long> businessSceneCreate(BusinessSceneCreateDTO businessSceneCreateDto);

    /**
    * 更新业务场景
    */
    ResultDTO<Boolean> businessSceneUpdate(BusinessSceneUpdateDTO businessSceneUpdateDto);

    /**
    * 删除业务场景
    */
    ResultDTO<Boolean> businessSceneRemove(BusinessSceneRemoveDTO businessSceneRemoveDto);

    /**
     * 查询业务场景详情
     */
    ResultDTO<BusinessSceneDTO> businessSceneDetailQuery(BusinessSceneDetailQuery query);

    /**
     * 查询业务场景列表详情
     */
    ResultDTO<List<BusinessSceneDTO>> businessSceneListQuery(BusinessSceneListQuery query);

    /**
     * 分页查询业务场景信息
     */
    ResultDTO<List<BusinessSceneDTO>> businessScenePageQuery(BusinessScenePageQuery pageQuery);
}