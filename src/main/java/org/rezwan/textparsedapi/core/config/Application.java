package org.rezwan.textparsedapi.core.config;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;


@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan(
        basePackages = {
            "org.rezwan.textparsedapi.core.config",            
            "org.rezwan.textparsedapi.core.service",            
            "org.rezwan.textparsedapi.api.endpoint",
        }
)
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> listConverters = new ArrayList<>();
        listConverters.add(new MappingJackson2HttpMessageConverter());
        listConverters.add(new MappingJackson2XmlHttpMessageConverter());

        restTemplate.setMessageConverters(listConverters);
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

        return restTemplate;
    }    
}
