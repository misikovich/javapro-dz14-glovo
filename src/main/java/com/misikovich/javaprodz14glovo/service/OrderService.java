package com.misikovich.javaprodz14glovo.service;

import com.misikovich.javaprodz14glovo.model.Order;
import com.misikovich.javaprodz14glovo.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private final Random random = new Random();

    public OrderService() {
        List<Product> products = new ArrayList<>();
        products.add(Product.builder().cost(100).name("Байрактар ТБ-2").build());
        products.add(Product.builder().cost(100).name("Байрактар ТБ-3").build());
        addOrder(Order.builder().cost(200).date(LocalDate.now()).products(products).build());
        products.add(Product.builder().cost(100).name("Байрактар ТБ-2").build());
        addOrder(Order.builder().cost(300).date(LocalDate.now()).products(products).build());
    }

    public Optional<Order> getOrderById(int id) {
        return orders.stream().filter(user -> user.getId() == id).findFirst();
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order addOrder(Order order) {
        order.setId(this.random.nextInt(Integer.MAX_VALUE));
        orders.add(order);
        return order;
    }
}
