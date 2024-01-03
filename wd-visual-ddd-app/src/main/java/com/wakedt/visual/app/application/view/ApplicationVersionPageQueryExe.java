package com.wakedt.visual.app.application.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.application.assembler.ApplicationVersionDTO2DOConvert;
import com.wakedt.visual.client.application.dto.ApplicationVersionDTO;
import com.wakedt.visual.client.application.query.ApplicationVersionPageQuery;
import com.wakedt.visual.domain.common.util.version.VersionSortUtil;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationVersionMapper;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationVersionDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分页查询应用版本信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationVersionPageQueryExe {

    @Resource
    private ApplicationVersionMapper applicationversionMapper;

    public PageResultDTO<List<ApplicationVersionDTO>> execute(ApplicationVersionPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(),pageQuery.getPageSize());

        List<ApplicationVersionDO> applicationversionDoList = applicationversionMapper.applicationVersionPageQuery(pageQuery);
        PageInfo<ApplicationVersionDO> pageInfo = new PageInfo<>(applicationversionDoList);
        List<ApplicationVersionDTO> applicationVersionDTOList = ApplicationVersionDTO2DOConvert.INSTANCE.doList2DtoList(pageInfo.getList());

        List<ApplicationVersionDTO> sortedList = getSortedList(applicationVersionDTOList);

        PageResultDTO<List<ApplicationVersionDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(sortedList);
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }

    private static List<ApplicationVersionDTO> getSortedList(List<ApplicationVersionDTO> domainDesignVersionDTOList) {
        Map<String, ApplicationVersionDTO> versionMap = domainDesignVersionDTOList.stream()
                .collect(Collectors.toMap(ApplicationVersionDTO::getCurrentVersion, data -> data, (a, b) -> b));
        return VersionSortUtil.sortMap(versionMap);
    }
}
