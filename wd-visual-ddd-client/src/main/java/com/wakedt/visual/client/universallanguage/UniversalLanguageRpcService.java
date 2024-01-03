package com.wakedt.visual.client.universallanguage;

import com.wakedata.common.core.dto.PageResultDTO;
import com.wakedata.common.core.dto.ResultDTO;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageAddDTO;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageDTO;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageDeleteDTO;
import com.wakedt.visual.client.universallanguage.dto.UniversalLanguageUpdateDTO;
import com.wakedt.visual.client.universallanguage.query.UniversalLanguageDetailQuery;
import com.wakedt.visual.client.universallanguage.query.UniversalLanguagePageQuery;

import java.util.List;

/**
 * 统一语言-聚合根-RPC能力接口
 *
 * @author zhuxueliang
 */
public interface UniversalLanguageRpcService {

    /**
    * 新增统一语言
    */
    ResultDTO<Long> universalLanguageAdd(UniversalLanguageAddDTO universalLanguageAddDto);

    /**
    * 更新统一语言
    */
    ResultDTO<Boolean> universalLanguageUpdate(UniversalLanguageUpdateDTO universalLanguageUpdateDto);

    /**
    * 删除统一语言
    */
    ResultDTO<Boolean> universalLanguageDelete(UniversalLanguageDeleteDTO universalLanguageDeleteDto);

    /**
     * 查询统一语言详情
     */
    ResultDTO<UniversalLanguageDTO> universalLanguageDetailQuery(UniversalLanguageDetailQuery query);

    /**
     * 分页查询统一语言信息
     */
    PageResultDTO<List<UniversalLanguageDTO>> universalLanguagePageQuery(UniversalLanguagePageQuery pageQuery);

}