package com.rjornelas.provider.service;

import com.rjornelas.provider.model.Product;
import com.rjornelas.provider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByState(String state) {
        return productRepository.findByState(state);
    }
}
