package com.example.gateway.api;


import com.example.gateway.dto.Client;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final String url = "http://10.100.60.224:8084/clients";

    @PostMapping
    public Client addClient(@RequestBody Client client){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Client> entity = restTemplate.postForEntity(url, client, Client.class);
        return  entity.getBody();
    }

    @GetMapping
    public List<Client> getAllClients(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Client>> entity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        return entity.getBody();
    }

    @GetMapping("{clientId}")
    public Client getClientById(@PathVariable String clientId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Client> entity = restTemplate.exchange(url+"/"+clientId, HttpMethod.GET, null,
                new ParameterizedTypeReference<>(){});
        return entity.getBody();
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable String clientId){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url + "/" + clientId, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<>() {
                });
    }
}
