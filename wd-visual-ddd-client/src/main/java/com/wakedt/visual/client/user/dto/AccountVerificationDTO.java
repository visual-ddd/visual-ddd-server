package com.wakedt.visual.client.user.dto;

import com.wakedata.common.core.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月13日 12:12:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "账号验证码信息")
public class AccountVerificationDTO extends BaseDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "账号")
    private String accountNo;

    @ApiModelProperty(value = "验证码")
    private String code;

}
