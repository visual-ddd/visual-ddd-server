package com.wakedt.visual.domain.universallanguage.universallanguage.update;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新统一语言-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "更新统一语言指令")
public class UniversalLanguageUpdateCmd {

    /** 主键id */
    private Long id;

    /** 概念 */
    private String conception;

    /** 英文名 */
    private String englishName;

    /** 定义 */
    private String definition;

    /** 约束 */
    private String restraint;

    private String example;

}