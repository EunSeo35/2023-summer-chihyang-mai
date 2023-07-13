package com.chihyangmai.backend.presentation.controller;

import com.chihyangmai.backend.application.dto.FundRequestDto;
import com.chihyangmai.backend.application.service.FundRequestService;
import com.chihyangmai.backend.presentation.request.AddFundRequest;
import com.chihyangmai.backend.presentation.response.FundInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController //
@RequestMapping("/api")
@RequiredArgsConstructor
public class FundRequestController {

    private final FundRequestService fundrequestService;

    @PostMapping("/fund")
    public ResponseEntity<Long> save(@RequestBody AddFundRequest request) {
        Long savedId = fundrequestService.addFund(FundRequestDto.from(request));
        return ResponseEntity.ok(savedId);
    }

    @GetMapping("/fund")
    public ResponseEntity<List<FundInfoResponse>> getAllFundRequests() {
        List<FundRequestDto> allFundReqestDtoList = fundrequestService.getAllFundRequests();
        List<FundInfoResponse> response = allFundReqestDtoList.stream().map(FundInfoResponse::from).collect(Collectors.toList());
        return ResponseEntity.ok(response);

    }
    @DeleteMapping("/fund")
    public ResponseEntity<Void> deleteById(@RequestParam Long id) {
        fundrequestService.deleteFundRequest(id);
        return ResponseEntity.ok(null);
    }

    @PatchMapping("/fund")
    public ResponseEntity<Void> changeRequestNumStatus(@RequestParam Long id) {
        fundrequestService.changeRequestNumInfo(id);
        return ResponseEntity.ok(null);
    }

}
