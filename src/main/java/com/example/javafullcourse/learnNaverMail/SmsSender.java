package com.example.javafullcourse.learnNaverMail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import static java.lang.String.valueOf;

@Service
public class SmsSender {
    private final WebClient webClient;
    private final SignatureUtil signatureUtil;
    @Value("${spring.naver.secretkey}")
    private String secretKey;
    @Value("${spring.naver.sms.serviceid}")
    private String serviceId;
    private String accessKey;

    SmsSender(@Value("${spring.naver.accesskey}")String accessKey) {
        this.accessKey = accessKey;
        this.webClient = WebClient.builder()
                .baseUrl("https://sens.apigw.ntruss.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name())
                .defaultHeader("x-ncp-iam-access-key",accessKey)
                .build();
        this.signatureUtil = new SignatureUtil();
    }

    public void sendSms () {
        String timeStamp = valueOf(System.currentTimeMillis());
        String basePath = "/sms/v2/services/";
        String fullPath = basePath+serviceId+"/messages";
        String signature = signatureUtil.makeSignature(timeStamp, accessKey, secretKey, fullPath);
        List<Messages> messages = new ArrayList<>();
        Messages message = new Messages("[수신번호]","");
        messages.add(message);
        SmsRequest smsRequest = new SmsRequest("SMS","COMM","[발신번호]","반갑습니다.", messages);
        webClient
                .method(HttpMethod.POST)
                .uri(uriBuilder -> uriBuilder.path(fullPath).build())
                .header("x-ncp-apigw-timestamp", timeStamp)
                .header("x-ncp-apigw-signature-v2", signature)
                .body(BodyInserters.fromValue(smsRequest))
                .retrieve()
                .bodyToMono(SmsRequest.class)
                .block();
    }
}
