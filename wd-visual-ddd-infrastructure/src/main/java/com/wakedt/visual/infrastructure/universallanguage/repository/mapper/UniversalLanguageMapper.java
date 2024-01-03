package com.wakedt.visual.infrastructure.universallanguage.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wakedt.visual.client.universallanguage.query.UniversalLanguageDetailQuery;
import com.wakedt.visual.client.universallanguage.query.UniversalLanguagePageQuery;
import com.wakedt.visual.infrastructure.universallanguage.repository.model.UniversalLanguageDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 统一语言Mapper接口
 *
 * @author zhuxueliang
 */
@Mapper
public interface UniversalLanguageMapper extends BaseMapper<UniversalLanguageDO> {

    /**
    * 查询统一语言详情
    */
    UniversalLanguageDO universalLanguageDetailQuery(UniversalLanguageDetailQuery query);

    /**
     * 分页查询统一语言信息
     */
    List<UniversalLanguageDO> universalLanguagePageQuery(UniversalLanguagePageQuery pageQuery);
}