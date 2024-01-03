package com.wakedt.visual.app.application.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.application.assembler.ApplicationDTO2DOConvert;
import com.wakedt.visual.client.application.dto.ApplicationDTO;
import com.wakedt.visual.client.application.query.ApplicationPageQuery;
import com.wakedt.visual.infrastructure.application.repository.mapper.ApplicationMapper;
import com.wakedt.visual.infrastructure.application.repository.model.ApplicationDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分页查询应用信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class ApplicationPageQueryExe {

    @Resource
    private ApplicationMapper applicationMapper;

    public PageResultDTO<List<ApplicationDTO>> execute(ApplicationPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(),pageQuery.getPageSize());

        List<ApplicationDO> applicationDoList = applicationMapper.applicationPageQuery(pageQuery);
        PageInfo<ApplicationDO> pageInfo = new PageInfo<>(applicationDoList);
        List<ApplicationDTO> applicationDTOList = ApplicationDTO2DOConvert.INSTANCE.doList2DtoList(pageInfo.getList());

        PageResultDTO<List<ApplicationDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(applicationDTOList);
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }
}
