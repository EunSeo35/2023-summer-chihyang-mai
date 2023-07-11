package com.chihyangmai.backend.presentation.controller;


import com.chihyangmai.backend.application.service.FundRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class FundRequestController {

    @DeleteMapping("/room")
    public ResponseEntity<Void> deleteById(@RequestParam Long fundrequestId) {
        FundRequestService.deleteFundRequest(fundrequestId);
        return ResponseEntity.ok(null);
    }


}
