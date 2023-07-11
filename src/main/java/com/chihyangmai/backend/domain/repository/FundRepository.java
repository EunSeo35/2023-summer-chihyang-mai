package com.chihyangmai.backend.domain.repository;

import com.chihyangmai.backend.domain.entity.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<Fund, Long> {
}
