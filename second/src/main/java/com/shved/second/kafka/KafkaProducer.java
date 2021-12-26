package com.shved.second.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    @Value(value = "${kafka.producer-config.topicName}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String key, String body) {
        log.info("sent to kafka topicName=[{}], key=[{}], body=[{}]", topicName, key, body);
        kafkaTemplate.send(topicName, key, body);
    }

}
