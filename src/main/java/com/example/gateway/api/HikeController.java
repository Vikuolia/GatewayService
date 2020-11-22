package com.example.gateway.api;

import com.example.gateway.dto.Hike;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/hike")
public class HikeController {

    private final String url = "http://hike:8087/";

    @PostMapping
    public Hike addHike(@RequestBody Hike hike){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Hike> entity = restTemplate.postForEntity(url, hike, Hike.class);
        return  entity.getBody();
    }

    @GetMapping
    public List<Hike> getAllHikes(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Hike>> entity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        return entity.getBody();
    }

    @GetMapping("{hikeId}")
    public Hike getHikeById(@PathVariable String hikeId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Hike> entity = restTemplate.exchange(url+"/"+hikeId, HttpMethod.GET, null,
                new ParameterizedTypeReference<>(){});
        return entity.getBody();
    }

    @DeleteMapping("{hikeId}")
    public ResponseEntity<Void> deleteHikeById(@PathVariable String hikeId){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url + "/" + hikeId, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<>() {
                });
    }

}
