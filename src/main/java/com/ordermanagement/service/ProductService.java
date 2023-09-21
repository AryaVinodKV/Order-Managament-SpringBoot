package com.ordermanagement.service;

import com.ordermanagement.model.Product;
import com.ordermanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts(String query){
        return productRepository.getAll(query);
    }

    public Product getProductById(Long id) throws Exception{
        Optional<Product> optionalOrder = productRepository.findById(id);
        if(optionalOrder.isPresent()) {
            return optionalOrder.get();
        }
        else{
            throw new Exception();
        }
    }
}
