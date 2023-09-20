package com.ordermanagement.service;

import com.ordermanagement.model.OrderItem;
import com.ordermanagement.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems(){
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) throws Exception{
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(id);
        if(optionalOrderItem.isPresent()) {
            return optionalOrderItem.get();
        }
        else{
            throw new Exception();
        }
    }
}
