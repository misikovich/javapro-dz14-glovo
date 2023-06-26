package com.misikovich.javaprodz14glovo.controller;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/adminOrderTable")
public class OrderTableController {
    private final ResourceLoader resourceLoader;

    public OrderTableController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping
    public @ResponseBody String getTable() throws IOException {
        return new String(resourceLoader.getResource("classpath:/static/OrderTable.html")
                .getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
