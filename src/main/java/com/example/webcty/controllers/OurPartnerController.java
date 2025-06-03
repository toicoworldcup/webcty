package com.example.webcty.controllers;

import com.example.webcty.dto.request.OurPartnerRequest;
import com.example.webcty.dto.response.OurPartnerResponse;
import com.example.webcty.services.OurPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/our-partner")
public class OurPartnerController {
    private final OurPartnerService ourPartnerService;

    @Autowired
    public OurPartnerController(OurPartnerService OurPartnerService) {
        this.ourPartnerService = OurPartnerService;
    }

    @GetMapping
    public ResponseEntity<List<OurPartnerResponse>> getAllOurPartner() {
        return ResponseEntity.ok(ourPartnerService.getAllOurPartner());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OurPartnerResponse> getOurPartnerById(@PathVariable Long id) {
        return ResponseEntity.ok(ourPartnerService.getOurPartnerById(id));
    }

    @PostMapping
    public ResponseEntity<OurPartnerResponse> createOurPartner(@RequestBody OurPartnerRequest ourPartner) {
        return ResponseEntity.ok(ourPartnerService.createOurPartner(ourPartner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OurPartnerResponse> updateOurPartner(@PathVariable Long id, @RequestBody OurPartnerRequest updateOurPartner) {
        return ResponseEntity.ok(ourPartnerService.updateOurPartner(id, updateOurPartner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOurPartner(@PathVariable Long id) {
        ourPartnerService.deleteOurPartner(id);
        return ResponseEntity.noContent().build();
    }
}