package com.wakedt.visual.domain.prompt.prompt.remove;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除提示词-指令
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptRemoveCmd {

    /** 提示词 ID */
    private Long id;

}