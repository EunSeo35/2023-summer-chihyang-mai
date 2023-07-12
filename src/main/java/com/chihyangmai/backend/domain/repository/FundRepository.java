package com.chihyangmai.backend.domain.repository;

import com.chihyangmai.backend.domain.entity.FundRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<FundRequest, Long> {
}
