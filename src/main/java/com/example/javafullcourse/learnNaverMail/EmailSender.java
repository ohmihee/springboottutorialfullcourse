package com.example.javafullcourse.learnNaverMail;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static java.lang.String.valueOf;

@Service
public class EmailSender {
    private final WebClient webClient;
    private final EmailUtil emailUtil;
    @Value("${spring.email.naver.secretKey}")
    private String secretKey;
    @Value("${spring.email.naver.serviceId}")
    private String serviceId;
    private String accessKey;

    EmailSender (@Value("{spring.naver.email.accessKey}")String accessKey) {
        this.accessKey = accessKey;
        this.webClient = WebClient.builder()
                .baseUrl("https://mail.apigw.ntruss.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                //.defaultHeader("accept-charset", "UTF-8")
                .defaultHeader("x-ncp-iam-access-key",accessKey)
                .build();
        this.emailUtil = new EmailUtil();
    }
    public void sendEmil () {
        String timeStamp = valueOf(System.currentTimeMillis());
        String method = "POST";
        //String defaultPath = "/api/v1/mails";
        String url = "/api/v1/mails";
        String signature = emailUtil.makeSignature(timeStamp, accessKey, secretKey, url);
        EmailForm emailForm = new EmailForm("o4881331@naver.com","ohmihee","가입을 축하드립니다.","가입이 승인되었습니다.");
        webClient
                .method(HttpMethod.POST)
                .uri(uriBuilder -> uriBuilder.path("/api/v1/mails").build())
                .header("x-ncp-apigw-timestamp", timeStamp)
                .header("x-ncp-apigw-signature-v2", signature)
                .body(Mono.just(emailForm), EmailForm.class)
                .retrieve()
                .bodyToMono(EmailForm.class)
                .block();

    }
}

// 시그니처 https://api.ncloud-docs.com/docs/common-ncpapi
