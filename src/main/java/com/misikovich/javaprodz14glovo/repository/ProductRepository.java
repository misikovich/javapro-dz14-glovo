package com.misikovich.javaprodz14glovo.repository;

import com.misikovich.javaprodz14glovo.model.Product;
import com.misikovich.javaprodz14glovo.repository.mapper.ProductRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
@AllArgsConstructor
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public Product getProductById(Long id) {
        return jdbcTemplate.queryForObject("select * from public.product where id = " + id, new ProductRowMapper());
    }

    public List<Product> getProductsByIdList(List<Long> ids) {
        String query = String.format("select * from public.product where id in (%s)", ids.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        return jdbcTemplate.query(query, new ProductRowMapper());
    }

    public void save(Product product) {
        jdbcTemplate.update("insert into public.product(name, cost) values (?, ?)",
                product.getName(),
                product.getCost());
    }
}
