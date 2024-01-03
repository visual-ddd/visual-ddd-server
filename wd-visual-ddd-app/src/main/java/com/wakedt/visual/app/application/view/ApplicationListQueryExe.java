package com.wakedt.visual.app.application.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.application.assembler.ApplicationDTO2DOConvert;
import com.wakedt.visual.client.application.dto.ApplicationDTO;
import com.wakedt.visual.client.application.query.ApplicationListQuery;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询应用列表详情-查询器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationListQueryExe {

    @Resource
    private ApplicationMapper applicationMapper;

    public ResultDTO<List<ApplicationDTO>> execute(ApplicationListQuery query) {
        List<ApplicationDTO> applicationDTOS =
                ApplicationDTO2DOConvert.INSTANCE.doList2DtoList(applicationMapper.applicationListQuery(query));
        return ResultDTO.success(applicationDTOS);
    }
}
