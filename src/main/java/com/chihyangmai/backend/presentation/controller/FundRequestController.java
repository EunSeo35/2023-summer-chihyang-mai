package com.chihyangmai.backend.presentation.controller;

import com.chihyangmai.backend.application.dto.FundDto;
import com.chihyangmai.backend.application.service.FundService;
import com.chihyangmai.backend.presentation.request.AddFundRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FundRequestController {

    @Autowired
    private final FundService fundService;

    // create funding
    @PostMapping("/fund")
    public ResponseEntity<Long> save(@RequestBody AddFundRequest request) {
        Long savedId = fundService.addFund(FundDto.from(request));
        return ResponseEntity.ok(savedId);
    }
}