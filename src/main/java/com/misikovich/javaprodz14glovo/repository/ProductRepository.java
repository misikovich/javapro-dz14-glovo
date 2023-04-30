package com.misikovich.javaprodz14glovo.repository;

import com.misikovich.javaprodz14glovo.model.Product;
import com.misikovich.javaprodz14glovo.repository.mapper.ProductRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
@AllArgsConstructor
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public Product get(Long id) {
        return jdbcTemplate.queryForObject("select * from public.product where id = " + id, new ProductRowMapper());
    }

    public Product update(Product product) {
        jdbcTemplate.update("update public.product set name = ?, cost = ? where id = ?",
                product.getName(),
                product.getCost(),
                product.getId());
        return product;
    }

    public Product delete(Long id) {
        jdbcTemplate.update("delete from public.product where id = " + id);
        return Product.builder().id(id).build();
    }

    public List<Product> getProductsByIdList(List<Long> ids) {
        if (ids.size() == 0) return new ArrayList<>();
        String query = String.format("select * from public.product where id in (%s)", ids.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        return jdbcTemplate.query(query, new ProductRowMapper());
    }

    public Product save(Product product) {
        jdbcTemplate.update("insert into public.product(name, cost) values (?, ?)",
                product.getName(),
                product.getCost());
        return product;
    }
}
