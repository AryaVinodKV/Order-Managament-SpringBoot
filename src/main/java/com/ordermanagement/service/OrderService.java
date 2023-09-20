package com.ordermanagement.service;

import com.ordermanagement.dto.OrderDto;
import com.ordermanagement.dto.OrderItemDto;
import com.ordermanagement.model.Customer;
import com.ordermanagement.model.Order;
import com.ordermanagement.model.OrderItem;
import com.ordermanagement.model.Product;
import com.ordermanagement.repository.CustomerRepository;
import com.ordermanagement.repository.OrderItemRepository;
import com.ordermanagement.repository.OrderRepository;
import com.ordermanagement.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderItemService orderItemService;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) throws Exception{
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()) {
            return optionalOrder.get();
        }
        else{
            throw new Exception();
        }
    }

    public void addOrder(OrderDto orderDto) throws Exception{

        Long customerId = orderDto.getCustomerId();
        Customer customer = customerService.getCustomerById(customerId);

        int totalQuantity = 0;
        int totalPrice = 0;

        for(OrderItemDto orderItem: orderDto.getOrderItems()){
            totalQuantity += orderItem.getQuantity();
            Long productId = orderItem.getProductId();
            Product product= productService.getProductById(productId);
            totalPrice += (product.getUnitPrice()*orderItem.getQuantity());
        }

        Order order = Order.builder()
                .customer(customer)
                .totalQuantity(totalQuantity)
                .totalPrice(totalPrice)
                .build();

        orderRepository.save(order);

        for(OrderItemDto orderItem: orderDto.getOrderItems()){
            Long productId = orderItem.getProductId();
            Product product= productService.getProductById(productId);

            OrderItem orderItem1 = OrderItem.builder()
                    .quantity(orderItem.getQuantity())
                    .order(order)
                    .price(product.getUnitPrice())
                    .rowTotal(product.getUnitPrice()*orderItem.getQuantity())
                    .product(productService.getProductById(productId))
                    .build();

            orderItemRepository.save(orderItem1);
        }

    }
}
