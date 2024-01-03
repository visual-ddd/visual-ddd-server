package com.wakedt.visual.domain.whitelist.whitelist.remove;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除白名单-指令
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhiteListRemoveCmd {

    /** 白名单 ID */
    private Long id;

}