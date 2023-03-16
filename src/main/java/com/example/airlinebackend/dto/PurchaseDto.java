package com.example.airlinebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseDto {
    private String userId;
    private String flightId;
    private double payedPrice;
    private Integer count;
}