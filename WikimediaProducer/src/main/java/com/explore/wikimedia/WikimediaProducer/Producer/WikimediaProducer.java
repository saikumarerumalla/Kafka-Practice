package com.explore.wikimedia.WikimediaProducer.Producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
//        log.info("Sending message to Wikimedia-stream topic : {}", msg);
        kafkaTemplate.send("wikimedia-stream", msg);
    }
}
