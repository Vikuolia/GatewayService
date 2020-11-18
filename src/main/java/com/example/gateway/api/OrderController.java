package com.example.gateway.api;

import com.example.gateway.dto.Order;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final String url = "http://orderserver:8089/orders/";

    @PostMapping
    public Order addOrder(@RequestBody Order order){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Order> entity = restTemplate.postForEntity(url, order, Order.class);
        return  entity.getBody();
    }

    @GetMapping
    public List<Order> getAllOrders(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Order>> entity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        return entity.getBody();
    }

    @GetMapping("{orderId}")
    public Order getOrderById(@PathVariable String orderId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Order> entity = restTemplate.exchange(url+"/"+orderId, HttpMethod.GET, null,
                new ParameterizedTypeReference<>(){});
        return entity.getBody();
    }

    @DeleteMapping("{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String orderId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url + "/" + orderId, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<>() {
                });
    }

    @DeleteMapping("{client}")
    public ResponseEntity<Void> deleteClientOrders(@PathVariable String client) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url + "/" + client, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<>() {
                });
    }
}


