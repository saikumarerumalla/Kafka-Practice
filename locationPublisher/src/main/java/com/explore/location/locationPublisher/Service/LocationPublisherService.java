package com.explore.location.locationPublisher.Service;

import com.explore.location.locationPublisher.Model.DriverLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LocationPublisherService {
    @Value("${kafka.topic.driver-location}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    public void publishLocation(DriverLocation location) {
        try {
            String key = location.getDriverId();
            String value = mapper.writeValueAsString(location);
            kafkaTemplate.send(topic, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
