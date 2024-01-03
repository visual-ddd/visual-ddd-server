package com.wakedt.visual.app.domaindesign.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.domaindesign.assembler.DomainDesignDTO2DOConvert;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignDTO;
import com.wakedt.visual.client.domaindesign.query.DomainDesignPageQuery;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分页查询业务域信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignPageQueryExe {

    @Resource
    private DomainDesignMapper domaindesignMapper;

    public PageResultDTO<List<DomainDesignDTO>> execute(DomainDesignPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(),pageQuery.getPageSize());

        List<DomainDesignDO> domaindesignDoList = domaindesignMapper.domainDesignPageQuery(pageQuery);
        PageInfo<DomainDesignDO> pageInfo = new PageInfo<>(domaindesignDoList);
        List<DomainDesignDTO> domainDesignDTOList = DomainDesignDTO2DOConvert.INSTANCE.doList2DtoList(pageInfo.getList());

        PageResultDTO<List<DomainDesignDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(domainDesignDTOList);
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }
}
