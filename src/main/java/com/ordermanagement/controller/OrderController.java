package com.ordermanagement.controller;

import com.ordermanagement.dto.OrderDto;
import com.ordermanagement.model.Order;
import com.ordermanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") final Long orderId) throws Exception{
        return orderService.getOrderById(orderId);
    }
    @PostMapping
    public void addOrder(@RequestBody OrderDto order) throws Exception{
        orderService.addOrder(order);
    }

}
