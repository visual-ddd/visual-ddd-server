package com.wakedt.visual.client.domaindesign.query;

import com.wakedata.common.core.base.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询业务域版本详情-查询对象
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "查询业务域版本详情查询对象")
public class DomainDesignVersionNoAuthRequest extends BaseQuery {

    @ApiModelProperty(value = "业务域版本的唯一标识")
    private Long id;

}