package com.example.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {

    private String clientId;
    private String name;
    private String surname;
    private int age;
    private int background;
    private boolean student;
    private boolean frequentBuyer;

    public Client(String id, String name, String surname, int age, int background, boolean student){
        this.clientId = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.background = background;
        this.student = student;
        this.frequentBuyer = false;
    }

}


