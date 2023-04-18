package com.misikovich.javaprodz14glovo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Integer id;
    private String name;
    private double cost;
}