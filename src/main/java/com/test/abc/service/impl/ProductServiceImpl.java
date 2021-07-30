package com.test.abc.service.impl;

import com.test.abc.dto.Product;
import com.test.abc.dto.Promotion;
import com.test.abc.dto.Season;
import com.test.abc.entity.ProductEntity;
import com.test.abc.repository.ProductRepository;
import com.test.abc.service.ProductService;
import com.test.abc.util.AppConstants;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProductList() {

        List<ProductEntity> productEntityList = productRepository.findAll();
        List<Product> productList = new ArrayList<>();

        for(ProductEntity p :productEntityList){
            Product product = new Product();

            product.setProductId(p.getProductId().toString());
            product.setName(p.getProductName());
            product.setPrice(p.getPrice());
            product.setIsGovernmentTaxEnabled(p.getGvtTaxEnabled());
            product.setGovernmentTax(p.getGvtTax());
            product.setExpiredDate(p.getExpiredDate());

            Promotion promotion = new Promotion();
            promotion.setPromotionId(p.getPromotionByPromotionId().getPromotionId().toString());
            promotion.setOffer(p.getPromotionByPromotionId().getOffer());

            Season season = new Season();
            season.setSeasonId(p.getPromotionByPromotionId().getSeasonBySeasonId().getSeasonId().toString());
            season.setSeasonName(p.getPromotionByPromotionId().getSeasonBySeasonId().getSeasonName());

            promotion.setSeason(season);

            product.setPromotion(promotion);

            productList.add(product);
        }

        return productList;
    }

    @Override
    public Product getProduct(String productId) {
        Product product = new Product();

        ProductEntity p = productRepository.getById(Integer.parseInt(productId));

        product.setProductId(p.getProductId().toString());
        product.setName(p.getProductName());
        product.setPrice(p.getPrice());
        product.setIsGovernmentTaxEnabled(p.getGvtTaxEnabled());
        product.setGovernmentTax(p.getGvtTax());
        product.setExpiredDate(p.getExpiredDate());

        Promotion promotion = new Promotion();
        promotion.setPromotionId(p.getPromotionByPromotionId().getPromotionId().toString());
        promotion.setOffer(p.getPromotionByPromotionId().getOffer());

        Season season = new Season();
        season.setSeasonId(p.getPromotionByPromotionId().getSeasonBySeasonId().getSeasonId().toString());
        season.setSeasonName(p.getPromotionByPromotionId().getSeasonBySeasonId().getSeasonName());

        promotion.setSeason(season);

        product.setPromotion(promotion);

        return product;
    }

    @Override
    public String addProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setExpiredDate(product.getExpiredDate());
        productEntity.setGvtTaxEnabled(product.getIsGovernmentTaxEnabled());
        productEntity.setGvtTax(product.getGovernmentTax());

        productRepository.save(productEntity);

        return AppConstants.RESPONSE_PRODUCT_ADD_SUCCESS;
    }

    @Override
    public String updateProduct(String productId, Product product) {
        ProductEntity productEntity = productRepository.getById(Integer.parseInt(productId));
        productEntity.setProductName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setExpiredDate(product.getExpiredDate());
        productEntity.setGvtTaxEnabled(product.getIsGovernmentTaxEnabled());
        productEntity.setGvtTax(product.getGovernmentTax());

        productRepository.save(productEntity);

        return AppConstants.RESPONSE_PRODUCT_UPDATE_SUCCESS;
    }

    @Override
    public String deleteProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(Integer.parseInt(productId));
        productRepository.delete(productEntity);

        return AppConstants.RESPONSE_PRODUCT_DELETE_SUCCESS;
    }
}
