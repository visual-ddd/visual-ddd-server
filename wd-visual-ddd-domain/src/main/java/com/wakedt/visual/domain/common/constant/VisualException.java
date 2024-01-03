package com.wakedt.visual.domain.common.constant;

import lombok.Getter;


/**
 * @author wangchensheng
 */
@Getter
public class VisualException extends RuntimeException {

    private final int code;

    public VisualException(MsgCodeEnum msgCodeEnum) {
        super(msgCodeEnum.getDesc());
        this.code = msgCodeEnum.getCode();
    }


    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
