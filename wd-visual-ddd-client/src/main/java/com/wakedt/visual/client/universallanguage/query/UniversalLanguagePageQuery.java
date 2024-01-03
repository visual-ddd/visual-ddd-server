package com.wakedt.visual.client.universallanguage.query;

import com.wakedata.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页查询统一语言信息-分页查询对象
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "分页查询统一语言信息分页查询对象")
public class UniversalLanguagePageQuery extends PageQuery {

    @ApiModelProperty(value = "概念")
    private String conception;

    @ApiModelProperty(value = "统一语言类型：1-组织统一语言，2-团队统一语言，3-业务域统一语言")
    private Integer languageType;

    @ApiModelProperty(value = "所属唯一标识(组织/团队的主键id)")
    private Long identity;
}