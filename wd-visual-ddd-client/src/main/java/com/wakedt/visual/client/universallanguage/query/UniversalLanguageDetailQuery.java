package com.wakedt.visual.client.universallanguage.query;

import com.wakedata.common.core.base.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询统一语言详情-查询对象
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "查询统一语言详情查询对象")
public class UniversalLanguageDetailQuery extends BaseQuery {

    @ApiModelProperty(value = "主键id")
    private Long id;

}