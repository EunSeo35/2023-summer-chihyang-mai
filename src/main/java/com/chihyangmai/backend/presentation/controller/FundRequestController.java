package com.chihyangmai.backend.presentation.controller;

import com.chihyangmai.backend.application.dto.FundDto;
import com.chihyangmai.backend.application.service.FundService;
import com.chihyangmai.backend.presentation.request.AddFundRequest;
import com.chihyangmai.backend.presentation.response.FundInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FundRequestController {

    @Autowired
    private final FundService fundService;

    // create funding
    @PostMapping("/fund")
    public ResponseEntity<Long> save(@RequestBody AddFundRequest request) {
        Long savedId = fundService.addFund(FundDto.toAdd(request));
        return ResponseEntity.ok(savedId);
    }

    @GetMapping("/fund")
    public ResponseEntity<List<FundInfoResponse>> getAllFeeds() {

        List<FundDto> allFundDtoList = fundService.getAllFunds();
        List<FundInfoResponse> response = allFundDtoList.stream()
                .map(FundInfoResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);

    }
}


