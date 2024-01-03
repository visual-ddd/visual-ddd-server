package com.wakedt.visual.domain.common.util.email;

import lombok.Builder;
import lombok.Data;

/**
 * @author WangChenSheng
 * date 2022/12/29 16:04
 */
@Data
@Builder
public class SendInfo {

    /**
     * 地址
     */
    private String mailUser;

    /**
     * 标题
     */
    private String mailSubject;

    /**
     * 内容
     */
    private String mailContent;

}