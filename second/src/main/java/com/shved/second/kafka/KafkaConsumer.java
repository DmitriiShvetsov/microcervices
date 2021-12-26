package com.shved.second.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.consumer-config.topicName}", groupId = "${kafka.consumer-config.groupId}")
    public void listenGroupFoo(String message) {
        log.info("Received Message in group foo: " + message);
    }

}
