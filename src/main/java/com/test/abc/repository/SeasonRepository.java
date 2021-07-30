package com.test.abc.repository;

import com.test.abc.entity.SeasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<SeasonEntity,Integer> {
}
