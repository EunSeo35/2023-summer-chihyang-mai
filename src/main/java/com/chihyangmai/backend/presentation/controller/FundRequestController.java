package com.chihyangmai.backend.presentation.controller;


import com.chihyangmai.backend.application.service.FundRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //
@RequestMapping("/api")
@RequiredArgsConstructor
public class FundRequestController {


    private final FundRequestService fundrequestService;

    @DeleteMapping("/fund")
    public ResponseEntity<Void> deleteById(@RequestParam Long fundrequestId) {
        fundrequestService.deleteFundRequest(fundrequestId);
        return ResponseEntity.ok(null);
    }


}
