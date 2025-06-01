package com.explore.wikimedia.WikimediaConsumer.Consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class wikimediaConsumer {

    @KafkaListener(topics = "wikimedia-stream", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info("Consuming message from wikimedia-stream topic : {}", msg);
    }


}
