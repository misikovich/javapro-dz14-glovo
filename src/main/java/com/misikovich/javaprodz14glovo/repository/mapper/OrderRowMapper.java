package com.misikovich.javaprodz14glovo.repository.mapper;

import com.misikovich.javaprodz14glovo.model.Order;
import com.misikovich.javaprodz14glovo.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Order.builder()
                .id(rs.getLong("id"))
                .date(rs.getDate("date"))
                .cost(rs.getDouble("cost"))
                .products(Arrays.stream((Long[]) rs.getArray("product_ids").getArray())
                        .map(value -> Product.builder().id(value).build())
                        .toList())
                .build();
    }
}
