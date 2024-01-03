package com.wakedt.visual.infrastructure.universallanguage.repository;

import com.wakedt.visual.domain.universallanguage.universallanguage.UniversalLanguage;
import com.wakedt.visual.domain.universallanguage.universallanguage.UniversalLanguageRepository;
import com.wakedt.visual.infrastructure.universallanguage.assembler.UniversalLanguageDoConvert;
import com.wakedt.visual.infrastructure.universallanguage.repository.mapper.UniversalLanguageMapper;
import com.wakedt.visual.infrastructure.universallanguage.repository.model.UniversalLanguageDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * 统一语言存储接口实现类
 *
 * @author zhuxueliang
 */
@Slf4j
@Component
public class UniversalLanguageRepositoryImpl implements UniversalLanguageRepository {

    @Resource
    private UniversalLanguageMapper universalLanguageMapper;

    @Override
    public UniversalLanguage save(UniversalLanguage universalLanguage) {
        UniversalLanguageDO universalLanguageDO = UniversalLanguageDoConvert.INSTANCE.dto2Do(universalLanguage);
        int insert = universalLanguageMapper.insert(universalLanguageDO);
        Assert.isTrue(insert == 1, "插入数据库异常，请联系管理员");
        return UniversalLanguageDoConvert.INSTANCE.do2Dto(universalLanguageDO);
    }

    @Override
    public UniversalLanguage update(UniversalLanguage universalLanguage) {
        UniversalLanguageDO universalLanguageDO = UniversalLanguageDoConvert.INSTANCE.dto2Do(universalLanguage);
        int update = universalLanguageMapper.updateById(universalLanguageDO);
        Assert.isTrue(update == 1, "更新数据库异常，请联系管理员");
        return UniversalLanguageDoConvert.INSTANCE.do2Dto(universalLanguageDO);
    }

    @Override
    public void remove(UniversalLanguage universalLanguage) {
        UniversalLanguageDO universalLanguageDO = UniversalLanguageDoConvert.INSTANCE.dto2Do(universalLanguage);
        universalLanguageMapper.deleteById(universalLanguageDO.getId());
    }

    @Override
    public UniversalLanguage find(Long id) {
        UniversalLanguageDO universalLanguage = universalLanguageMapper.selectById(id);
        return UniversalLanguageDoConvert.INSTANCE.do2Dto(universalLanguage);
    }
}
