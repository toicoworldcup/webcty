package com.example.webcty.controllers;

import com.example.webcty.dto.request.ServiceBannerRequest;
import com.example.webcty.dto.response.ServiceBannerResponse;
import com.example.webcty.services.ServiceBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-banner")
public class ServiceBannerController {
    private final ServiceBannerService serviceBannerService;

    @Autowired
    public ServiceBannerController(ServiceBannerService serviceBannerService) {
        this.serviceBannerService = serviceBannerService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceBannerResponse>> getAllServiceBanner() {
        return ResponseEntity.ok(serviceBannerService.getAllServiceBanner());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceBannerResponse> getServiceBannerById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceBannerService.getServiceBannerById(id));
    }

    @PostMapping
    public ResponseEntity<ServiceBannerResponse> createServiceBanner(@RequestBody ServiceBannerRequest serviceBanner) {
        return ResponseEntity.ok(serviceBannerService.createServiceBanner(serviceBanner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceBannerResponse> updateServiceBanner(@PathVariable Long id, @RequestBody ServiceBannerRequest updateServiceBanner) {
        return ResponseEntity.ok(serviceBannerService.updateServiceBanner(id, updateServiceBanner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceBanner(@PathVariable Long id) {
        serviceBannerService.deleteServiceBanner(id);
        return ResponseEntity.noContent().build();
    }
}