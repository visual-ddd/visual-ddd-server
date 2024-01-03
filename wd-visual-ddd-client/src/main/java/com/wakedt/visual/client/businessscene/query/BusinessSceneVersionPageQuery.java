package com.wakedt.visual.client.businessscene.query;

import com.wakedata.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页查询业务场景版本信息-分页查询对象
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "分页查询业务场景版本信息分页查询对象")
public class BusinessSceneVersionPageQuery extends PageQuery {

    @ApiModelProperty(value = "所属业务场景ID")
    private Long businessSceneId;

}