package com.wakedt.visual.app.whitelist.view;

import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.app.whitelist.assembler.WhiteListDTO2WhiteListDOConvert;
import com.wakedt.visual.client.whitelist.dto.WhiteListDTO;
import com.wakedt.visual.client.whitelist.query.WhiteListQuery;
import com.wakedt.visual.infrastructure.whitelist.repository.mapper.WhiteListMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 查询白名单详情-查询器
 */
@Component
public class WhiteListQueryExe {

    @Resource
    private WhiteListMapper mapper;

    public ResultDTO<WhiteListDTO> execute(WhiteListQuery query) {
        return ResultDTO.success(
                WhiteListDTO2WhiteListDOConvert.INSTANCE.do2Dto(mapper.whiteListQuery(query)));
    }
}
