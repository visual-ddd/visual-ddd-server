package com.wakedt.visual.app.businessscene.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.businessscene.assembler.BusinessSceneDTO2DOConvert;
import com.wakedt.visual.client.businessscene.dto.BusinessSceneDTO;
import com.wakedt.visual.client.businessscene.query.BusinessScenePageQuery;
import com.wakedt.visual.infrastructure.businessscene.repository.mapper.BusinessSceneMapper;
import com.wakedt.visual.infrastructure.businessscene.repository.model.BusinessSceneDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分页查询业务场景信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class BusinessScenePageQueryExe {

    @Resource
    private BusinessSceneMapper businesssceneMapper;

    public PageResultDTO<List<BusinessSceneDTO>> execute(BusinessScenePageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(),pageQuery.getPageSize());

        List<BusinessSceneDO> businesssceneDoList = businesssceneMapper.businessScenePageQuery(pageQuery);
        PageInfo<BusinessSceneDO> pageInfo = new PageInfo<>(businesssceneDoList);
        List<BusinessSceneDTO> businessSceneDTOList = BusinessSceneDTO2DOConvert.INSTANCE.doList2DtoList(pageInfo.getList());

        PageResultDTO<List<BusinessSceneDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(businessSceneDTOList);
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }
}
