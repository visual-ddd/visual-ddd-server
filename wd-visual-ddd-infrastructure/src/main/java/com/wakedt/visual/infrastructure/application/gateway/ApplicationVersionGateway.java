package com.wakedt.visual.infrastructure.application.gateway;

import java.util.zip.ZipOutputStream;

/**
 * 应用版本信息-外部防腐层接口
 *
 * @author shimmer
 */
public interface ApplicationVersionGateway {

    /**
     * 根据应用版本信息生成代码，并返回到输出流中
     *
     * @param applicationDsl 应用DSL
     * @param outputStream   压缩流
     */
    void generateCode(String applicationDsl, ZipOutputStream outputStream);
}
