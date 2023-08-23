package com.shved.second.controller;

import com.shved.second.kafka.KafkaProducer;
import com.shved.second.service.ArmySenderService;
import com.shved.storage.dto.army.Army;
import com.shved.storage.dto.rest.InfoMessageRequest;
import com.shved.storage.dto.rest.InfoMessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InfoMessageController {

    private final KafkaProducer kafkaProducer;
    private final ArmySenderService armySenderService;

    @PostMapping("/message/test")
    public InfoMessageResponse receiveMessage(@RequestBody InfoMessageRequest request) {
        log.info("received message =[{}]", request);

        kafkaProducer.sendMessage(request.getId(), request.getMessage());

        InfoMessageResponse infoMessageResponse = getInfoMessageResponse();
        log.info("generated response =[{}]", infoMessageResponse);
        return infoMessageResponse;
    }
    @GetMapping("/message/test")
    public String test() {
        log.info("test message");

        return "test message";
    }

    @PostMapping("/army")
    public void receiveArmy(@RequestBody Army army) {
        log.info("received army =[{}]", army);
        armySenderService.sendArmy(army);
    }

    private InfoMessageResponse getInfoMessageResponse() {
        InfoMessageResponse infoMessageResponse = new InfoMessageResponse();
        infoMessageResponse.setStatus("end " + LocalDateTime.now().toString());
        return infoMessageResponse;
    }

}
