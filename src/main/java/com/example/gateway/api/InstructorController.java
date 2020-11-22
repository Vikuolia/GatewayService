package com.example.gateway.api;

import com.example.gateway.dto.Instructor;
import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@NoArgsConstructor
public class InstructorController {

    private final String url = "http://instructor:8087/";

    @PostMapping
    public Instructor addInstructor(@RequestBody Instructor instructor){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Instructor> entity = restTemplate.postForEntity(url, instructor, Instructor.class);
        return  entity.getBody();
    }

    @GetMapping
    public List<Instructor> getAllInstructors(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Instructor>> entity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
        });
        return entity.getBody();
    }

    @GetMapping("{instructorId}")
    public Instructor getInstructorById(@PathVariable String instructorId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Instructor> entity = restTemplate.exchange(url+"/"+instructorId, HttpMethod.GET, null,
                new ParameterizedTypeReference<>(){});
        return entity.getBody();
    }

    @DeleteMapping("{instructorId}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable String instructorId){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url + "/" + instructorId, HttpMethod.DELETE, null,
                new ParameterizedTypeReference<>() {
                });
    }

}
