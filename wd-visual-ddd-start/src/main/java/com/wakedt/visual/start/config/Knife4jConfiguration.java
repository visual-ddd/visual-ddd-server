package com.wakedt.visual.start.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Bean(value = "dockerBean")
    public Docket dockerBean() {
        //指定使用Swagger2规范
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(new ApiInfoBuilder()
                //描述字段支持Markdown语法
                .description("# DDD可视化开发平台")
                .termsOfServiceUrl("https://doc.xiaominfo.com/")
                .contact(new Contact("高智意，黎贵奇，祝学梁，王晨升", "", ""))
                .version("1.0")
                .build())
            //分组名称
            .groupName("代码生成平台服务")
            .select()
            //这里指定Controller扫描包路径
            .apis(RequestHandlerSelectors.basePackage("com.wakedt.visual"))
            .paths(PathSelectors.any())
            .build();
    }

}