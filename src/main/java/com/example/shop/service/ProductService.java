package com.example.shop.service;

import com.example.shop.entity.Product;
import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAll();
}
