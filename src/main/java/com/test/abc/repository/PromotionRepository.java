package com.test.abc.repository;

import com.test.abc.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<PromotionEntity,Integer> {
}
