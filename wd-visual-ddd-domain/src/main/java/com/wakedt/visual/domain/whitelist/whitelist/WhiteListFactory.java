package com.wakedt.visual.domain.whitelist.whitelist;

import com.wakedt.visual.domain.whitelist.whitelist.create.WhiteListCreateCmd;
import org.springframework.stereotype.Component;

/**
 * 描述账号白名单-聚合根-工厂
 */
@Component
public class WhiteListFactory {

    public WhiteList getInstance(WhiteListCreateCmd createCmd) {
        WhiteList instance = new WhiteList();
        instance.setAccountNo(createCmd.getAccountNo());
        instance.setDescription(createCmd.getDescription());
        return instance;
    }

}
