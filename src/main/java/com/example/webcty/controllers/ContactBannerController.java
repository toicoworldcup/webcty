package com.example.webcty.controllers;

import com.example.webcty.dto.request.ContactBannerRequest;
import com.example.webcty.dto.response.ContactBannerResponse;
import com.example.webcty.services.ContactBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-banner")
public class ContactBannerController {
    private final ContactBannerService contactBannerService;

    @Autowired
    public ContactBannerController(ContactBannerService contactBannerService) {
        this.contactBannerService = contactBannerService;
    }

    @GetMapping
    public ResponseEntity<List<ContactBannerResponse>> getAllContactBanner() {
        return ResponseEntity.ok(contactBannerService.getAllContactBanner());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactBannerResponse> getContactBannerById(@PathVariable Long id) {
        return ResponseEntity.ok(contactBannerService.getContactBannerById(id));
    }

    @PostMapping
    public ResponseEntity<ContactBannerResponse> createContactBanner(@RequestBody ContactBannerRequest ContactBanner) {
        return ResponseEntity.ok(contactBannerService.createContactBanner(ContactBanner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactBannerResponse> updateContactBanner(@PathVariable Long id, @RequestBody ContactBannerRequest updateContactBanner) {
        return ResponseEntity.ok(contactBannerService.updateContactBanner(id, updateContactBanner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactBanner(@PathVariable Long id) {
        contactBannerService.deleteContactBanner(id);
        return ResponseEntity.noContent().build();
    }
}