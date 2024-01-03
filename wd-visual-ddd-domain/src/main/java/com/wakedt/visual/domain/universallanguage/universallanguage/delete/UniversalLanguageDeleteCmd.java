package com.wakedt.visual.domain.universallanguage.universallanguage.delete;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除统一语言-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "删除统一语言指令")
public class UniversalLanguageDeleteCmd {

    /** 主键id */
    private Long id;

}