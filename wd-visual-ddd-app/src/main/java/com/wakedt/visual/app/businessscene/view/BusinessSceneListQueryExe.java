package com.wakedt.visual.app.businessscene.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.businessscene.assembler.BusinessSceneDTO2DOConvert;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneDTO;
import com.wakedt.visual.client.businessscene.query.BusinessSceneListQuery;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询业务场景列表详情-查询器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneListQueryExe {

    @Resource
    private BusinessSceneMapper businesssceneMapper;

    public ResultDTO<List<BusinessSceneDTO>> execute(BusinessSceneListQuery query) {
        List<BusinessSceneDTO> businessSceneDTOS =
                BusinessSceneDTO2DOConvert.INSTANCE.doList2DtoList(businesssceneMapper.businessSceneListQuery(query));
        return ResultDTO.success(businessSceneDTOS);
    }
}
