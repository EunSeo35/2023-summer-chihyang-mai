package com.chihyangmai.backend.application.service;

import com.chihyangmai.backend.application.dto.ContentDto;
import com.chihyangmai.backend.application.dto.FundDto;
import com.chihyangmai.backend.domain.entity.FundRequest;
import com.chihyangmai.backend.domain.entity.User;
import com.chihyangmai.backend.domain.repository.FundRepository;
import com.chihyangmai.backend.domain.repository.UserRepository;
import jdk.internal.jimage.ImageStrings;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FundService {
    private final FundRepository fundRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long addFund(FundDto dto) {
        User user = userRepository.findById(dto.getWriterId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        FundRequest newFundRequest = fundRepository.save(FundRequest.toFund(dto,user));
        return newFundRequest.getId();
    }

    @Transactional
    public List<FundDto> getAllFunds() {
        List<FundRequest> allFundListRequest = fundRepository.findAll();
        for (FundRequest f : allFundListRequest) {
            List<ContentDto> contentDtoList = f.getContentList().stream().map(ContentDto::from)
                    .collect(Collectors.toList());
            allFundDtoList.add(FundDto.from(f, contentDtoList));
            return  allFundListRequest;
        }
    }
}



