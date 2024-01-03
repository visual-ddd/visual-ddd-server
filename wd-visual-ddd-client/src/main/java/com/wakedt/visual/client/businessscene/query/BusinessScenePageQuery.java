package com.wakedt.visual.client.businessscene.query;

import com.wakedata.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页查询业务场景信息-分页查询对象
 *
 * @author zhuxueliang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "分页查询业务场景信息分页查询对象")
public class BusinessScenePageQuery extends PageQuery {

    @ApiModelProperty(value = "所属团队ID")
    private Long teamId;

    @ApiModelProperty(value = "名称")
    private String name;

}