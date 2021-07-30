package com.test.abc.service.impl;

import com.test.abc.dto.Product;
import com.test.abc.entity.ProductEntity;
import com.test.abc.entity.PromotionEntity;
import com.test.abc.entity.SeasonEntity;
import com.test.abc.repository.ProductRepository;
import com.test.abc.repository.PromotionRepository;
import com.test.abc.repository.SeasonRepository;
import com.test.abc.service.PromotionService;
import com.test.abc.util.AppConstants;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;
    private final ProductRepository productRepository;
    private final SeasonRepository seasonRepository;

    public PromotionServiceImpl(PromotionRepository promotionRepository, ProductRepository productRepository, SeasonRepository seasonRepository) {
        this.promotionRepository = promotionRepository;
        this.productRepository = productRepository;
        this.seasonRepository = seasonRepository;
    }

    @Override
    public String addPromotion(Product product, String productId) {
        PromotionEntity promotionEntity = new PromotionEntity();

        //add season entity to db
        SeasonEntity seasonEntity = new SeasonEntity();
        seasonEntity.setSeasonName(AppConstants.NEW_YEAR_SEASON);
        seasonRepository.save(seasonEntity);

        promotionEntity.setOffer(product.getPromotion().getOffer());
        promotionEntity.setSeasonBySeasonId(seasonEntity);

        //add promotion to db
        promotionRepository.save(promotionEntity);

        ProductEntity productEntity = productRepository.getById(Integer.parseInt(productId));
        productEntity.setPromotionByPromotionId(promotionEntity);

        //add promotion to particular product
        productRepository.save(productEntity);

        return AppConstants.RESPONSE_PROMOTION_ADD_SUCCESS;
    }

}
