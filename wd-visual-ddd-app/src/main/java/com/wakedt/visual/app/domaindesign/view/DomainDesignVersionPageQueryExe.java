package com.wakedt.visual.app.domaindesign.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.domaindesign.assembler.DomainDesignVersionDTO2DOConvert;
import com.wakedt.visual.client.domaindesign.dto.DomainDesignVersionDTO;
import com.wakedt.visual.client.domaindesign.query.DomainDesignVersionPageQuery;
import com.wakedt.visual.domain.common.util.version.VersionSortUtil;
import com.wakedt.visual.infrastructure.domaindesign.repository.mapper.DomainDesignVersionMapper;
import com.wakedt.visual.infrastructure.domaindesign.repository.model.DomainDesignVersionDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分页查询业务域版本信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class DomainDesignVersionPageQueryExe {

    @Resource
    private DomainDesignVersionMapper domaindesignversionMapper;

    public PageResultDTO<List<DomainDesignVersionDTO>> execute(DomainDesignVersionPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(),pageQuery.getPageSize());

        List<DomainDesignVersionDO> domainDesignVersionDoList = domaindesignversionMapper.domainDesignVersionPageQuery(pageQuery);
        PageInfo<DomainDesignVersionDO> pageInfo = new PageInfo<>(domainDesignVersionDoList);
        List<DomainDesignVersionDTO> domainDesignVersionDTOList = DomainDesignVersionDTO2DOConvert.INSTANCE.doList2DtoList(pageInfo.getList());

        List<DomainDesignVersionDTO> sortedList = getSortedList(domainDesignVersionDTOList);

        PageResultDTO<List<DomainDesignVersionDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(sortedList);
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }

    private static List<DomainDesignVersionDTO> getSortedList(List<DomainDesignVersionDTO> domainDesignVersionDTOList) {
        Map<String, DomainDesignVersionDTO> versionMap = domainDesignVersionDTOList.stream()
                .collect(Collectors.toMap(DomainDesignVersionDTO::getCurrentVersion, data -> data, (a, b) -> b));
        return VersionSortUtil.sortMap(versionMap);
    }
}
