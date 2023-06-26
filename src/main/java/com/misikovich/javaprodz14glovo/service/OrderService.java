package com.misikovich.javaprodz14glovo.service;

import com.misikovich.javaprodz14glovo.model.Order;
import com.misikovich.javaprodz14glovo.model.Product;
import com.misikovich.javaprodz14glovo.repository.OrderRepository;
import com.misikovich.javaprodz14glovo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        productRepository.save(Product.builder().name("Bayraktar TB-1").cost(50000).build());
        productRepository.save(Product.builder().name("DJI Mavic Mini").cost(800).build());
        productRepository.save(Product.builder().name("BinderoMobil").cost(666).build());
        productRepository.save(Product.builder().name("Boris Johnson").cost(666).build());

        List<Product> products1 = new ArrayList<>();
        products1.add(Product.builder().id(4L).build());
        products1.add(Product.builder().id(3L).build());
        products1.add(Product.builder().id(2L).build());
        products1.add(Product.builder().id(1L).build());

        List<Product> products2 = new ArrayList<>();
        products2.add(Product.builder().id(2L).build());
        products2.add(Product.builder().id(3L).build());

        List<Product> products3 = new ArrayList<>();
        products3.add(Product.builder().id(3L).build());
        products3.add(Product.builder().id(1L).build());
        products3.add(Product.builder().id(1L).build());
        products3.add(Product.builder().id(6L).build());
        products3.add(Product.builder().id(5L).build());
        products3.add(Product.builder().id(4L).build());

        addOrder(Order.builder().date(new Date(4343636325235L)).products(products1).build());
        addOrder(Order.builder().date(new Date(5343636323116L)).products(products2).build());
        addOrder(Order.builder().date(new Date(435343636323111L)).products(products3).build());
        addOrder(Order.builder().date(new Date(443636320629L)).products(products1).build());
        addOrder(Order.builder().date(new Date(4234211320629L)).products(products1).build());
        addOrder(Order.builder().date(new Date(44363624320629L)).products(products1).build());
        addOrder(Order.builder().date(new Date(4636323145L)).products(products2).build());
    }

    public Order getOrderById(int id) {
        Order order = orderRepository.getById(id);
        order.setProducts(getProducts(order));
        return order;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.getAll();
        orders.forEach(order -> order.setProducts(getProducts(order)));
        return orders;
    }

    public Order addOrder(Order order) {

        order.setCost(getProducts(order).stream().mapToDouble(Product::getCost).sum());
        orderRepository.save(order);
        return order;
    }

    private List<Product> getProducts(Order order) {
//        DEPRECATED
//        return order.getProducts().stream().map(product -> productRepository.getProductById(product.getId())).toList();
        List<Long> productsIds = order.getProducts().stream()
                .map(Product::getId)
                .toList();
        return productRepository.getProductsByIdList(productsIds);
    }
}
