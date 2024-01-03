package com.wakedt.visual.app.universallanguage.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.universallanguage.assembler.UniversalLanguageDTO2DOConvert;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageDTO;
import com.wakedt.visual.client.universallanguage.query.UniversalLanguagePageQuery;
import com.wakedt.visual.infrastructure.universallanguage.repository.mapper.UniversalLanguageMapper;
import com.wakedt.visual.infrastructure.universallanguage.repository.model.UniversalLanguageDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分页查询统一语言信息-分页查询器
 *
 * @author zhuxueliang
 */
@Component
public class UniversalLanguagePageQueryExe {

    @Resource
    private UniversalLanguageMapper universallanguageMapper;

    public PageResultDTO<List<UniversalLanguageDTO>> execute(UniversalLanguagePageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getPageSize());

        List<UniversalLanguageDO> universallanguageDoList = universallanguageMapper.universalLanguagePageQuery(pageQuery);
        PageInfo<UniversalLanguageDO> pageInfo = new PageInfo<>(universallanguageDoList);
        List<UniversalLanguageDTO> universalLanguageDTOList = UniversalLanguageDTO2DOConvert.INSTANCE.doList2DtoList(pageInfo.getList());

        PageResultDTO<List<UniversalLanguageDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(universalLanguageDTOList);
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }
}
