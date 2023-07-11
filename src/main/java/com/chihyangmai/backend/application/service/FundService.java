package com.chihyangmai.backend.application.service;

import com.chihyangmai.backend.application.dto.FundDto;
import com.chihyangmai.backend.domain.entity.Fund;
import com.chihyangmai.backend.domain.repository.FundRepository;
import com.chihyangmai.backend.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FundService {
    private final FundRepository fundRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long addFund(FundDto dto){
        Fund newFund = fundRepository.save(Fund.toFund(dto));
        return newFund.getWriterId();
    }
}


