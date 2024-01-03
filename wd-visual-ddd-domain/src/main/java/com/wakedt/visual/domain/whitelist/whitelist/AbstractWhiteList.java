package com.wakedt.visual.domain.whitelist.whitelist;

import lombok.Data;

/**
 * 描述账号白名单-聚合根
 */
@Data
public abstract class AbstractWhiteList {

    /** 白名单 ID */
    private Long id;

    /** 账号 */
    private String accountNo;

    /** 描述 */
    private String description;

}