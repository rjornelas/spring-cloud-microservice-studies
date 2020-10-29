package com.rjornelas.provider.repository;

import com.rjornelas.provider.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByState(String state);

    List<Product> findByIdIn(List<Long> id);
}