package com.company.hackathon.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.base.Predicates;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableEncryptableProperties
@PropertySource(value = "classpath:application.properties")
@EnableSwagger2
@ComponentScan("com.company.hackathon.rest")
public class ControllerConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
    
    @Bean
    public Docket api() {
        List<ResponseMessage> list = new ArrayList<>();
        list.add(new ResponseMessage(200, "Ok", null, Collections.emptyMap(), Collections.emptyList()));
        list.add(new ResponseMessage(400, "Invalid request", null, Collections.emptyMap(), Collections.emptyList()));
        list.add(new ResponseMessage(401, "Unauthorized", null, Collections.emptyMap(), Collections.emptyList()));
        list.add(new ResponseMessage(404, "Not found", null, Collections.emptyMap(), Collections.emptyList()));
        list.add(new ResponseMessage(500, "Server error", null, Collections.emptyMap(), Collections.emptyList()));


        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, list)
                .globalResponseMessage(RequestMethod.POST, list)
                .globalResponseMessage(RequestMethod.PUT, list)
                .globalResponseMessage(RequestMethod.DELETE, list)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.hackathon.rest"))
                .paths(Predicates.or(
                        PathSelectors.ant("/client/**")
                    ))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Hackathon Rest API",
                "Hackathon Rest API.",
                "1.0",
                "Terms of service",
                null,
                null, null, Collections.emptyList());
    }
}
