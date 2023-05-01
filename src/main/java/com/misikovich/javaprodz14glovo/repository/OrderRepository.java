package com.misikovich.javaprodz14glovo.repository;

import com.misikovich.javaprodz14glovo.model.Order;
import com.misikovich.javaprodz14glovo.model.Product;
import com.misikovich.javaprodz14glovo.repository.mapper.OrderRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@AllArgsConstructor
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    public Order getById(long id) {
        return jdbcTemplate.queryForObject("select * from public.order where id = " + id, new OrderRowMapper());
    }

    public List<Order> getAll() {
        return jdbcTemplate.query("select * from public.order", new OrderRowMapper());
    }

    public void save(Order order) {
        Long[] product_ids = order.getProducts().stream()
                .map(Product::getId)
                .toList().toArray(new Long[0]);
        jdbcTemplate.update("insert into public.order(date, cost, product_ids) values (?, ?, ?)",
                order.getDate(),
                order.getCost(),
                product_ids);
    }

    public void update(Order order) {
        Long[] product_ids = order.getProducts().stream()
                .map(Product::getId)
                .toList().toArray(new Long[0]);
        jdbcTemplate.update("update public.order set date = ?, cost = ?, product_ids = ? where id = ?",
                order.getDate(),
                order.getCost(),
                product_ids,
                order.getId());
    }

    public void delete(long id) {
        jdbcTemplate.update("delete from public.order where id = " + id);
    }
}
