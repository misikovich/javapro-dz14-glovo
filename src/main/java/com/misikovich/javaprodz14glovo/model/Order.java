package com.misikovich.javaprodz14glovo.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Order {
    private Integer id;
    private LocalDate date;
    private double cost;
    private List<Product> products;
}
