package com.wakedt.visual.app.businessscene.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.businessscene.assembler.BusinessSceneVersionDTO2DOConvert;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneVersionDTO;
import com.wakedt.visual.client.businessscene.query.BusinessSceneVersionPageQuery;
import com.wakedt.visual.domain.common.util.version.VersionSortUtil;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneVersionMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneVersionDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分页查询业务场景版本信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessSceneVersionPageQueryExe {

    @Resource
    private BusinessSceneVersionMapper businesssceneversionMapper;

    public PageResultDTO<List<BusinessSceneVersionDTO>> execute(BusinessSceneVersionPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(),pageQuery.getPageSize());

        List<BusinessSceneVersionDO> businesssceneversionDoList = businesssceneversionMapper.businessSceneVersionPageQuery(pageQuery);
        PageInfo<BusinessSceneVersionDO> pageInfo = new PageInfo<>(businesssceneversionDoList);
        List<BusinessSceneVersionDTO> businessSceneVersionDTOList = BusinessSceneVersionDTO2DOConvert.INSTANCE.doList2DtoList(pageInfo.getList());

        List<BusinessSceneVersionDTO> sortedList = getSortedList(businessSceneVersionDTOList);

        PageResultDTO<List<BusinessSceneVersionDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(sortedList);
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }

    private static List<BusinessSceneVersionDTO> getSortedList(List<BusinessSceneVersionDTO> domainDesignVersionDTOList) {
        Map<String, BusinessSceneVersionDTO> versionMap = domainDesignVersionDTOList.stream()
                .collect(Collectors.toMap(BusinessSceneVersionDTO::getCurrentVersion, data -> data, (a, b) -> b));
        return VersionSortUtil.sortMap(versionMap);
    }
}
