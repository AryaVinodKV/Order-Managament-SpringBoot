package com.ordermanagement.repository;

import com.ordermanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT u FROM Product u WHERE (:query IS NULL OR u.name LIKE %:query%)")
    List<Product> getAll(String query);
}
