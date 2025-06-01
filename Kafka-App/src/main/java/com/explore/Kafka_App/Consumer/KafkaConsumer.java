package com.explore.Kafka_App.Consumer;

import com.explore.Kafka_App.Payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    //    @KafkaListener(topics = "arya", groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info("Consuming message from Arya topic : {}", msg);
    }

    @KafkaListener(topics = "arya", groupId = "myGroup")
    public void consumeJsonMsg(Student msg) {
        log.info("Consuming message from Arya topic : {}", msg.toString());
    }

}
