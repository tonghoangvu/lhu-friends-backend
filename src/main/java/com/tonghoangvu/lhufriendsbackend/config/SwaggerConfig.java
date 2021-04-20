package com.tonghoangvu.lhufriendsbackend.config;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    @Contract(" -> new")
    private @NotNull ApiInfo apiInfo() {
        return new ApiInfo(
                "lhu-friends-backend",
                "Backend API cho tiện ích tìm kiếm bạn bè LHU",
                "2.0.0",
                "/terms-of-service",
                new Contact(
                        "Tong Hoang Vu",
                        "https://github.com/tonghoangvu",
                        "tonghoangvu@outlook.com"),
                "MIT",
                "https://github.com/tonghoangvu/lhu-friends-backend/blob/master/LICENSE",
                Collections.emptyList());
    }
}
