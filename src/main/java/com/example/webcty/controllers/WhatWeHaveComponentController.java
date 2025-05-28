package com.example.webcty.controllers;

import com.example.webcty.dto.request.WhatWeHaveComponentRequest;
import com.example.webcty.dto.response.WhatWeHaveComponentResponse;
import com.example.webcty.services.WhatWeHaveComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/what-we-have-component")
public class WhatWeHaveComponentController {
    private final WhatWeHaveComponentService whatWeHaveComponentService;

    @Autowired
    public WhatWeHaveComponentController(WhatWeHaveComponentService whatWeHaveComponentService) {
        this.whatWeHaveComponentService = whatWeHaveComponentService;
    }

    @GetMapping
    public ResponseEntity<List<WhatWeHaveComponentResponse>> getAllWhatWeHave() {
        return ResponseEntity.ok(whatWeHaveComponentService.getAllWhatWeHave());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WhatWeHaveComponentResponse> getWhatWeHaveById(@PathVariable Long id) {
        return ResponseEntity.ok(whatWeHaveComponentService.getWhatWeHaveById(id));
    }

    @PostMapping
    public ResponseEntity<WhatWeHaveComponentResponse> createWhatWeHave(@RequestBody WhatWeHaveComponentRequest WhatWeHave) {
        return ResponseEntity.ok(whatWeHaveComponentService.createWhatWeHave(WhatWeHave));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WhatWeHaveComponentResponse> updateWhatWeHave(@PathVariable Long id, @RequestBody WhatWeHaveComponentRequest updatedWhatWeHave) {
        return ResponseEntity.ok(whatWeHaveComponentService.updateWhatWeHave(id, updatedWhatWeHave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWhatWeHave(@PathVariable Long id) {
        whatWeHaveComponentService.deleteWhatWeHave(id);
        return ResponseEntity.noContent().build();
    }
}