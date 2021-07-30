package com.test.abc.controller;

import com.test.abc.dto.Product;
import com.test.abc.service.ProductService;
import com.test.abc.util.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> retrieveAllProducts() {
        List<Product> productList = new ArrayList<>();

        try {
            productList = productService.getAllProductList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        String response;
        try {
            response = productService.addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();

            response = AppConstants.RESPONSE_PRODUCT_ADD_FAIL;
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        Product product = new Product();
        try {
            product = productService.getProduct(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<String> updateProduct(@RequestBody Product product,@PathVariable String productId) {
        String response;
        try {
            response = productService.updateProduct(productId,product);
        } catch (Exception e) {
            e.printStackTrace();

            response = AppConstants.RESPONSE_PRODUCT_UPDATE_FAIL;
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId) {
        String response;
        try {
            response = productService.deleteProduct(productId);
        } catch (Exception e) {
            e.printStackTrace();

            response = AppConstants.RESPONSE_PRODUCT_DELETE_FAIL;
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
