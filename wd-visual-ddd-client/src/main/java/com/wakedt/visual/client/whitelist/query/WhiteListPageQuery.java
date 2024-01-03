package com.wakedt.visual.client.whitelist.query;

import com.wakedata.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页查询白名单
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "分页查询白名单")
public class WhiteListPageQuery extends PageQuery {

}