package com.wakedt.visual.domain.whitelist.whitelist.modify;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 编辑白名单-指令
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhiteListModifyCmd {

    /** 白名单 ID */
    private Long id;

    /** 账号 */
    private String accountNo;

    /** 描述 */
    private String description;

}