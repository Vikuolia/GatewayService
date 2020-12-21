package com.example.gateway.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Worker {

    private String workerId;
    private String name;
    private String surname;
    private Position position;

    public Worker(String id, String name, String surname, Position position){
        this.workerId = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
    }
}


