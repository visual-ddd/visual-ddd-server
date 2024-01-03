package com.wakedt.visual.domain.whitelist.whitelist;

/**
 * 描述账号白名单-聚合根-仓储接口
 */
public interface WhiteListRepository {

    WhiteList save(WhiteList whiteList);

    WhiteList update(WhiteList whiteList);

    void remove(WhiteList whiteList);

    WhiteList find(Long id);

    /**
     * 校验账号是否在白名单中
     */
    void checkAccountNoInWhiteList(String accountNo);

}
