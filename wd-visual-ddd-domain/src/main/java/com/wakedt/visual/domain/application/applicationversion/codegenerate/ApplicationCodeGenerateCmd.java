package com.wakedt.visual.domain.application.applicationversion.codegenerate;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.zip.ZipOutputStream;

/**
 * 生成应用代码-指令
 *
 * @author zhuxueliang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "生成应用代码指令")
public class ApplicationCodeGenerateCmd {

    /** 主键 */
    private Long id;

    /** 输出流 */
    private ZipOutputStream outputStream;

}