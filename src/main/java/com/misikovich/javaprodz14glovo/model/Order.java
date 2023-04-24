package com.misikovich.javaprodz14glovo.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Builder
public class Order {
    private Long id;
    private Date date;
    private double cost;
    private List<Product> products;
}
