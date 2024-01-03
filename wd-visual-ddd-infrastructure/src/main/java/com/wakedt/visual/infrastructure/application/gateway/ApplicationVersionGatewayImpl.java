package com.wakedt.visual.infrastructure.application.gateway;

import com.wd.paas.dsl.ApplicationDsl;
import com.wd.paas.generator.CodeGenerateService;
import com.wd.paas.generator.common.util.GsonUtil;
import com.wd.paas.generator.generate.visitor.velocitytemplate.TemplateContext;
import com.wd.paas.generator.generate.visitor.velocitytemplate.TemplateVisitor;
import org.springframework.stereotype.Service;

import java.util.zip.ZipOutputStream;

/**
 * 应用版本信息-外部防腐层接口实现
 *
 * @author shimmer
 */
@Service
public class ApplicationVersionGatewayImpl implements ApplicationVersionGateway {

    @Override
    public void generateCode(String dsl, ZipOutputStream outputStream) {
        TemplateVisitor templateVisitor = new TemplateVisitor(new TemplateContext(outputStream));
        ApplicationDsl applicationDsl = GsonUtil.fromJson(dsl, ApplicationDsl.class);
        CodeGenerateService codeGenerateService = new CodeGenerateService(applicationDsl);
        codeGenerateService.run(templateVisitor);
    }
}
