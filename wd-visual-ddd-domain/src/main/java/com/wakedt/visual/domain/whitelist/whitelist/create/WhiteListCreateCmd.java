package com.wakedt.visual.domain.whitelist.whitelist.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新增白名单-指令
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhiteListCreateCmd {

    /** 账号 */
    private String accountNo;

    /** 描述 */
    private String description;

}