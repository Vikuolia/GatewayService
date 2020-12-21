package com.example.gateway.api.RestControllers;

import com.example.gateway.dto.Worker;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final String url = "http://worker:8087/";

    @PostMapping
    public Worker addWorker(@RequestBody Worker worker){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Worker> entity = restTemplate.postForEntity(url, worker, Worker.class);
        return  entity.getBody();
    }

    @GetMapping
    public List<Worker> getAllWorkers(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Worker>> entity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        return entity.getBody();
    }

    @DeleteMapping("{workerId}")
    public ResponseEntity<Void> deleteWorkerById(@PathVariable String workerId){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url + "/" + workerId, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<>() {
                });
    }
}
