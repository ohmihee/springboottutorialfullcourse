package com.example.springBootAndReact.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class AmazonConfig {

    private String accessKey;
    private String secretKey;

    @PostConstruct
    public void init (@Value("${aws.accessKey}") String accessKey, @Value("${aws.secretKey}") String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }


}
