package com.wakedt.visual.app.domaindesign.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.domaindesign.assembler.DomainDesignVersionDTO2DOConvert;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignVersionDTO;
import com.wakedt.visual.client.domaindesign.query.DomainDesignVersionDetailQuery;
import com.wakedt.visual.domain.common.constant.MsgCodeEnum;
import com.wakedt.visual.domain.common.constant.VisualException;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignVersionMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignVersionDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 查询业务域版本简介-查询器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignVersionSimpleQueryExe {

    @Resource
    private DomainDesignVersionMapper domaindesignversionMapper;

    public ResultDTO<DomainDesignVersionDTO> execute(DomainDesignVersionDetailQuery query) {
        DomainDesignVersionDO domaindesignversionDO = Optional.ofNullable(domaindesignversionMapper.domainDesignVersionSimpleQuery(query))
                .orElseThrow(() -> new VisualException(MsgCodeEnum.NO_FIND_RESOURCE));
        DomainDesignVersionDTO domainDesignVersionDTO = DomainDesignVersionDTO2DOConvert.INSTANCE.do2Dto(domaindesignversionDO);
        return ResultDTO.success(domainDesignVersionDTO);
    }
}
