package com.hoo.framework.swagger.config;

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
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by ravihoo on 04/03/2018.
 */
@Configuration  // spring加载配置
@EnableSwagger2 // 启动swagger2
public class Swagger2Config {

    private final static String CONTACT_NAME = "Hoo";
    private final static String CONTACT_URL = "";
    private final static String CONTACT_EMAIL = "";

    private boolean enableSwagger = true;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enableSwagger)
                .select().apis(RequestHandlerSelectors
                        .withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("基础平台 RESTful APIs").description(
                        "基础平台 RESTful 风格的接口文档，内容详细，极大的减少了前后端的沟通成本，" +
                                "同时确保代码与文档保持高度一致，极大的减少维护文档的时间。")
                .termsOfServiceUrl("http://baidu.com")
                .contact(getContact())
                .version("1.0.0").build();

    }

    private Contact getContact(){
        return new Contact(CONTACT_NAME,CONTACT_URL,CONTACT_EMAIL);
    }


}
