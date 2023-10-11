package org.example.abstraction.service;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;


//Лучше разделить на интерфейс и имплементацию
@Service
public class Client {
    //Пример запросов с клиента


    Mono<String> get(Object value){
        return getClient()
                .post()
                .uri("/getSomth")
                .bodyValue(value)
                .retrieve()
                .bodyToMono(Object.class)
                .map(Object::toString);
    }

    WebClient getClient() {
        return WebClient.builder()
                .baseUrl("localhost:9999/")
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create()))
                .build();
    }
}
