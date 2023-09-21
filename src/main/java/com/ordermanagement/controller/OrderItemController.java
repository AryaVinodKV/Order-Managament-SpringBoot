package com.ordermanagement.controller;

import com.ordermanagement.model.OrderItem;
import com.ordermanagement.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public List<OrderItem> getAllOrderItems(){
        log.info("Fetched All OrderItems");
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{id}")
    public OrderItem getOrderItemById(@PathVariable("id") final Long orderItemId) throws Exception{

        log.info("Fetched OrderItem by Id : " + orderItemId);
        return orderItemService.getOrderItemById(orderItemId);
    }

}