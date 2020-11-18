package com.example.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;


@Data
@AllArgsConstructor
public class Worker {

    private UUID workerId;
    private String name;
    private String surname;
    private Position position;

    public Worker(String name, String surname, Position position){
        this.name = name;
        this.surname = surname;
        this.position = position;
    }
}


