package com.wakedt.visual.domain.common.constant;

/**
 * author Wangchensheng@wakedata.com
 * date 2023年02月09日 11:16:09
 */
public enum MsgCodeEnum {

    EXPIRE_LOGIN(401, "登陆过期"),
    NO_FIND_RESOURCE(404, "未找到资源！")
    ;


    /**
     * 错误码
     */
    private int code;

    /**
     * 错误描述
     */
    private String desc;
    MsgCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public int getCode() {
        return code;
    }


    private void setCode(int code) {
        this.code = code;
    }


    public String getDesc() {
        return desc;
    }


    private void setDesc(String desc) {
        this.desc = desc;
    }

    }
