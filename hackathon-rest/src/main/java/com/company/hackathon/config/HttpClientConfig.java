package com.company.hackathon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration
@ComponentScan("com.company.hackathon.httpclient")
@EnableEncryptableProperties
@PropertySource(value = "classpath:application.properties")
public class HttpClientConfig {

}
