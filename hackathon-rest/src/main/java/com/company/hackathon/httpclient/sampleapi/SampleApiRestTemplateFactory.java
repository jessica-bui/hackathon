package com.company.hackathon.httpclient.sampleapi;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.company.hackathon.httpclient.HttpComponentsClientHttpRequestFactoryBasicAuth;

/**
 * Helper class for rest template
 */
@Component
public class SampleApiRestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean {
	
    private RestTemplate restTemplate;

    @Value("${sampleApi.host}")
    private String host;

    public String getHost() {
        return host;
    }

    public RestTemplate getObject() {
        return restTemplate;
    }

    public Class<RestTemplate> getObjectType() {
        return RestTemplate.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() {
        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactoryBasicAuth(HttpHost.create(host)));
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);
    }
}
