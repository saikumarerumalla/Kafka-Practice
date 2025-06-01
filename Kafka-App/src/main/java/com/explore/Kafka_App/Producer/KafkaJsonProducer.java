package com.explore.Kafka_App.Producer;

import com.explore.Kafka_App.Payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendMessage(Student student) {
        log.info("Sending message to Arya topic : {}", student);
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "arya")
                .build();
        kafkaTemplate.send(message);
    }
}
