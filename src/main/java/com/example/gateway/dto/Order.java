package com.example.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    private String orderId;
    private String date;
    private double price;
    private Status status;

    private String clientId;

    private String sellerId;

    private String hikeId;


    public Order(String id, String clientId, String sellerId, String hikeId){
        this.orderId = id;
        this.clientId = clientId;
        this.sellerId = sellerId;
        this.date = new Date().toString();
        this.hikeId = hikeId;
        this.price = 0;
        this.status = Status.inProgress;
    }

}

