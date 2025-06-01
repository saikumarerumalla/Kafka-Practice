package com.explore.wikimedia.WikimediaProducer.Stream;

import com.explore.wikimedia.WikimediaProducer.Producer.WikimediaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikimediaProducer producer;


    public WikimediaStreamConsumer(WikimediaProducer producer, WebClient.Builder webClientBuilder) {
        this.producer = producer;
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2").build();
    }

   public void consumeStreamAndPublish(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);
   }






}
