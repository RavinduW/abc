package com.test.abc.service;

import com.test.abc.dto.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProductList();

    Product getProduct(String productId);

    String addProduct(Product product);

    String updateProduct(String productId,Product product);

    String deleteProduct(String productId);
}
