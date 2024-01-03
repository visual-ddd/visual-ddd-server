package com.wakedt.visual.app.domaindesign.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.domaindesign.assembler.DomainDesignDTO2DOConvert;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignDTO;
import com.wakedt.visual.client.domaindesign.query.DomainDesignListQuery;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询业务域详情-查询器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignListQueryExe {

    @Resource
    private DomainDesignMapper domaindesignMapper;

    public ResultDTO<List<DomainDesignDTO>> execute(DomainDesignListQuery query) {
        List<DomainDesignDTO> domainDesignDTOS =
                DomainDesignDTO2DOConvert.INSTANCE.doList2DtoList(domaindesignMapper.domainDesignListQuery(query));
        return ResultDTO.success(domainDesignDTOS);
    }
}
