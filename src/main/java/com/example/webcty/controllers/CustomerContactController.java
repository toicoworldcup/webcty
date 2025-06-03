package com.example.webcty.controllers;

import com.example.webcty.dto.request.CustomerContactRequest;
import com.example.webcty.dto.response.CustomerContactResponse;
import com.example.webcty.services.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-contact")
public class CustomerContactController {
    private final CustomerContactService customerContactService;

    @Autowired
    public CustomerContactController(CustomerContactService customerContactService) {
        this.customerContactService = customerContactService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerContactResponse>> getAllCustomerContacts() {
        return ResponseEntity.ok(customerContactService.getAllCustomerContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerContactResponse> getCustomerContactById(@PathVariable Long id) {
        return ResponseEntity.ok(customerContactService.getCustomerContactById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerContactResponse> createCustomerContact(@RequestBody CustomerContactRequest customerContact) {
        return ResponseEntity.ok(customerContactService.createCustomerContact(customerContact));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerContactResponse> updateCustomerContact(@PathVariable Long id, @RequestBody CustomerContactRequest updateCustomerContact) {
        return ResponseEntity.ok(customerContactService.updateCustomerContact(id, updateCustomerContact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerContact(@PathVariable Long id) {
        customerContactService.deleteCustomerContact(id);
        return ResponseEntity.noContent().build();
    }
}