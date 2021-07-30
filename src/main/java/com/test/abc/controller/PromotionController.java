package com.test.abc.controller;

import com.test.abc.dto.Product;
import com.test.abc.service.PromotionService;
import com.test.abc.util.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PromotionController {

    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @PutMapping("/promotion/{productId}")
    public ResponseEntity<String> addPromotionToProduct(@PathVariable String productId, @RequestBody Product product) {
        String response;
        try {
            response = promotionService.addPromotion(product, productId);
        } catch (Exception e) {
            e.printStackTrace();

            response = AppConstants.RESPONSE_PROMOTION_ADD_FAIL;
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
