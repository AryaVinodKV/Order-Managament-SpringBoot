package com.ordermanagement.controller;

import com.ordermanagement.dto.OrderDto;
import com.ordermanagement.model.Order;
import com.ordermanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        log.info("Fetched All Orders");
        return orderService.getAllOrders(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") final Long orderId) throws Exception{
        log.info("Fetched Order by Id : " + orderId);
        return orderService.getOrderById(orderId);
    }
    @PostMapping
    public void addOrder(@RequestBody OrderDto order) throws Exception{
        log.info("Added new Order");
        orderService.addOrder(order);
    }

}
