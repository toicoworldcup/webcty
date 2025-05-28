package com.example.webcty.controllers;

import com.example.webcty.dto.request.WhatWeHaveRequest;
import com.example.webcty.dto.response.WhatWeHaveResponse;
import com.example.webcty.services.WhatWeHaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/what-we-have")
public class WhatWeHaveController {
    private final WhatWeHaveService whatWeHaveService;

    @Autowired
    public WhatWeHaveController(WhatWeHaveService whatWeHaveService) {
        this.whatWeHaveService = whatWeHaveService;
    }

    @GetMapping
    public ResponseEntity<List<WhatWeHaveResponse>> getAllWhatWeHave() {
        return ResponseEntity.ok(whatWeHaveService.getAllWhatWeHave());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WhatWeHaveResponse> getWhatWeHaveById(@PathVariable Long id) {
        return ResponseEntity.ok(whatWeHaveService.getWhatWeHaveById(id));
    }

    @PostMapping
    public ResponseEntity<WhatWeHaveResponse> createWhatWeHave(@RequestBody WhatWeHaveRequest whatWeHave) {
        return ResponseEntity.ok(whatWeHaveService.createWhatWeHave(whatWeHave));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WhatWeHaveResponse> updateWhatWeHave(@PathVariable Long id, @RequestBody WhatWeHaveRequest updateWhatWeHave) {
        return ResponseEntity.ok(whatWeHaveService.updateWhatWeHave(id, updateWhatWeHave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWhatWeHave(@PathVariable Long id) {
        whatWeHaveService.deleteWhatWeHave(id);
        return ResponseEntity.noContent().build();
    }
}