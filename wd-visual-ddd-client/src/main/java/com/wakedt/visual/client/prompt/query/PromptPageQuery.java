package com.wakedt.visual.client.prompt.query;

import com.wakedata.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页查询提示词
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "分页查询提示词")
public class PromptPageQuery extends PageQuery {

}