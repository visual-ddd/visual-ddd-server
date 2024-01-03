package com.wakedt.visual.app.whitelist.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedt.visual.app.whitelist.assembler.WhiteListDTO2WhiteListDOConvert;
import com.wakedt.visual.client.whitelist.dto.WhiteListDTO;
import com.wakedt.visual.client.whitelist.query.WhiteListPageQuery;
import com.wakedt.visual.infrastructure.whitelist.repository.mapper.WhiteListMapper;
import com.wakedt.visual.infrastructure.whitelist.repository.model.WhiteListDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分页查询白名单-查询器
 */
@Component
public class WhiteListPageQueryExe {

    @Resource
    private WhiteListMapper mapper;

    public PageResultDTO<List<WhiteListDTO>> execute(WhiteListPageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNo(),pageQuery.getPageSize());

        PageInfo<WhiteListDO> pageInfo = new PageInfo<>(mapper.whiteListPageQuery(pageQuery));
        PageResultDTO<List<WhiteListDTO>> pageResultDTO = new PageResultDTO<>();
        pageResultDTO.setData(WhiteListDTO2WhiteListDOConvert.INSTANCE.doList2DtoList(pageInfo.getList()));
        pageResultDTO.setPageNo(pageInfo.getPageNum());
        pageResultDTO.setPageSize(pageInfo.getSize());
        pageResultDTO.setTotalCount(pageInfo.getTotal());
        return pageResultDTO;
    }
}
