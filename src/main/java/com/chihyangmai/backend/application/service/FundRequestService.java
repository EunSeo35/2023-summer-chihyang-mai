package com.chihyangmai.backend.application.service;

import com.chihyangmai.backend.application.dto.ContentDto;
import com.chihyangmai.backend.application.dto.FundRequestDto;
import com.chihyangmai.backend.domain.entity.Content;
import com.chihyangmai.backend.domain.entity.FundRequest;
import com.chihyangmai.backend.domain.entity.User;
import com.chihyangmai.backend.domain.repository.FundRequestRepository;
import com.chihyangmai.backend.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FundRequestService {

    private final FundRequestRepository fundrequestRepository;
    private final UserRepository userRepository;

    @Transactional
    public void deleteFundRequest(Long fundrequestId){
        System.out.println("fundrequest Id = " + fundrequestId);
        fundrequestRepository.deleteById(fundrequestId);
    }

    @Transactional
    public void changeRequestNumInfo(Long id) {
        FundRequest fundRequest = fundrequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no such fundrequest"));
        fundRequest.setRequest_num(fundRequest.getRequest_num() + 1);
        fundrequestRepository.save(fundRequest);
    }

    @Transactional
    public Long addFund(FundRequestDto dto) {
//        User user = userRepository.findById(dto.getWriterId()).orElseThrow(() -> new IllegalArgumentException("No such user"));
        FundRequest newFundRequest = fundrequestRepository.save(FundRequest.toFund(dto));
        List<Content> contentList = dto.getImageUrlsStr().stream()
                .map(url -> Content.toContent(url, newFundRequest))
                .collect(Collectors.toList());
        newFundRequest.setContentList(contentList);

        return newFundRequest.getId();
    }

    @Transactional
    public List<FundRequestDto> getAllFundRequests() {
        List<FundRequest> allFundRequestList = fundrequestRepository.findAll();
        List<FundRequestDto> allFundRequestDtoList = new ArrayList<>();
        for (FundRequest f : allFundRequestList) {
            List<ContentDto> contentDtoList = f.getContentList().stream().map(ContentDto::from)
                    .collect(Collectors.toList());
            allFundRequestDtoList.add(FundRequestDto.from(f, contentDtoList));
        }
        return allFundRequestDtoList;
    }

}
