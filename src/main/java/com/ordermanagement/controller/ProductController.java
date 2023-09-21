package com.ordermanagement.controller;

import com.ordermanagement.model.Product;
import com.ordermanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.List;

@RestController
@RequestMapping("v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProductByQuery(@RequestParam(value = "Query", required = false) String query){
        return productService.getAllProducts(query);
    }
}
