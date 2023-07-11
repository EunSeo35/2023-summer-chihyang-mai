package com.chihyangmai.backend.application.service;

import com.chihyangmai.backend.domain.repository.FundRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class FundRequestService {
    private final FundRequestRepository fundrequestRepository;
    @Transactional
    public void deleteFundRequest(Long fundrequestId){
        System.out.println("roomId = " + fundrequestId);
        fundrequestRepository.deleteById(fundrequestId);
    }
}
