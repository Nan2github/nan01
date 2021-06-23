package com.example.nandemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ConsumWebService {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/template/products")
    public String getProductList(){
       // System.out.println("Consume Rest Service using RestTemplate-------");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList((MediaType.APPLICATION_JSON)));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/nandemo-0.0.1-SNAPSHOT/products", HttpMethod.GET, entity, String.class).getBody();
    }
}
