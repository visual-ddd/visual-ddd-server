package com.wakedt.visual.app.businessscene.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.businessscene.assembler.BusinessSceneVersionDTO2DOConvert;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneVersionDTO;
import com.wakedt.visual.client.businessscene.query.BusinessSceneVersionDetailQuery;
import com.wakedt.visual.domain.common.constant.MsgCodeEnum;
import com.wakedt.visual.domain.common.constant.VisualException;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneVersionMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneVersionDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 查询业务场景版本简介-查询器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneVersionSimpleQueryExe {

    @Resource
    private BusinessSceneVersionMapper businessSceneVersionMapper;

    public ResultDTO<BusinessSceneVersionDTO> execute(BusinessSceneVersionDetailQuery query) {
        BusinessSceneVersionDO businesssceneversionDO = Optional.ofNullable(businessSceneVersionMapper.businessSceneVersionSimpleQuery(query))
                .orElseThrow(() -> new VisualException(MsgCodeEnum.NO_FIND_RESOURCE));
        BusinessSceneVersionDTO businessSceneVersionDTO = BusinessSceneVersionDTO2DOConvert.INSTANCE.do2Dto(businesssceneversionDO);
        return ResultDTO.success(businessSceneVersionDTO);
    }
}
