package com.example.demoSleuth.external;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
@Slf4j
public class SelfCall implements ThirdParty {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServletWebServerApplicationContext server;


    @Override
    public void call() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+ server.getWebServer().getPort() +"/self";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();

        HttpEntity requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
        log.info("Response is - "+ result.getStatusCode().is2xxSuccessful());
    }
}
