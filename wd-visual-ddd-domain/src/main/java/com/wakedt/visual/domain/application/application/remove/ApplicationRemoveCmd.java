package com.wakedt.visual.domain.application.application.remove;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除应用-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "删除应用指令")
public class ApplicationRemoveCmd {

    /** 主键 */
    private Long id;

}