package com.shved.third.service;

import com.shved.third.service.RestServiceFirst;
import com.shved.storage.dto.rest.InfoMessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.shved.storage.dto.rest.InfoMessageRequest;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestServiceFirstImpl implements RestServiceFirst {

    @Value("${rest-receiver.host}")
    private String host;
    @Value("${rest-receiver.endpoints.message}")
    private String message;

    @Autowired
    private final RestTemplate restTemplate;

    @Override
    public void doRequest() {
        InfoMessageRequest infoMessageRequest = getInfoMessageRequest();
        log.info("generated request =[{}]",infoMessageRequest);

        InfoMessageResponse result = restTemplate.postForObject(host + message, infoMessageRequest, InfoMessageResponse.class);

        log.info("received response =[{}]",result);

    }

    private InfoMessageRequest getInfoMessageRequest() {
        String text = "start " + LocalDateTime.now().toString();
        InfoMessageRequest infoMessageRequest = new InfoMessageRequest();
        infoMessageRequest.setId(UUID.randomUUID().toString());
        infoMessageRequest.setMessage(text);
        return infoMessageRequest;
    }

}
