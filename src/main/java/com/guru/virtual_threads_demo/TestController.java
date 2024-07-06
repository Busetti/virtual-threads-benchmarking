package com.guru.virtual_threads_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class TestController {

    private final RestClient restClient;

    public TestController(RestClient.Builder restClient) {
        this.restClient = restClient
                .baseUrl("http://localhost:8081")
                .build();
    }

    @GetMapping("/test")
    public String test(){
        System.out.println(Thread.currentThread().getName());
        return restClient.get()
                .uri("/block")
                .retrieve().body(String.class);
    }


}
