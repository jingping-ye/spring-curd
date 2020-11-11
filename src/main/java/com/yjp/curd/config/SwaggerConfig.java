package com.yjp.curd.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()// 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))// 对所有api进行监控
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("基础CURD文档")
                .description("基础CURD接口文档")
                .version("1.0")
                .contact(new Contact("jingping.ye", "1104639669@qq.com", "1104639669@qq.com"))
                .build();
    }
}
