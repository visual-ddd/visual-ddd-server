package com.wakedt.visual.domain.universallanguage.universallanguage;

/**
 * 统一语言-聚合根-仓储接口
 *
 * @author zhuxueliang
 */
public interface UniversalLanguageRepository {

    UniversalLanguage save(UniversalLanguage universalLanguage);

    UniversalLanguage update(UniversalLanguage universalLanguage);

    void remove(UniversalLanguage universalLanguage);

    UniversalLanguage find(Long id);

}
