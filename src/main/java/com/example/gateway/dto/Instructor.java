package com.example.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public final class Instructor{

    private String instructorId;
    private String name;
    private String surname;
    private int background;

    public Instructor(String name, String surname, int background){
        this.name = name;
        this.surname = surname;
        this.background = background;
    }
}


