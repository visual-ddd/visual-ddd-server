package com.wakedt.visual.client.user.dto;

import com.wakedata.common.core.context.BaseUserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WangChenSheng
 * date 2022/12/30 11:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccountInfo extends BaseUserInfo {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 账号唯一标识
     */
    private String accountNo;

    /**
     * 描述
     */
    private String desc;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 是否为系统管理员
     */
    private Boolean isAdmin;

    /**
     * 描述
     */
    private String description;

    /**
     * sessionId
     */
    private String sessionId;
}
