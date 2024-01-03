package com.wakedt.visual.domain.whitelist.whitelist;

import com.wakedt.visual.domain.whitelist.whitelist.modify.WhiteListModifyCmd;
import com.wakedt.visual.domain.whitelist.whitelist.remove.WhiteListRemoveCmd;

/**
 * 描述账号白名单-聚合根能力
 */
public class WhiteList extends AbstractWhiteList {

    public void modify(WhiteListModifyCmd updateCmd) {
        this.setId(updateCmd.getId());
        this.setAccountNo(updateCmd.getAccountNo());
        this.setDescription(updateCmd.getDescription());
    }

    public void remove(WhiteListRemoveCmd removeCmd) {
        this.setId(removeCmd.getId());
    }
}