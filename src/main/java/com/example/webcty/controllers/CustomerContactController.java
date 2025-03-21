package com.example.webcty.controllers;

import com.example.webcty.entities.CustomerContact;
import com.example.webcty.services.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-contacts")
public class CustomerContactController {
    private final CustomerContactService customerContactService;

    @Autowired
    public CustomerContactController(CustomerContactService customerContactService) {
        this.customerContactService = customerContactService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerContact>> getAllCustomerContacts() {
        return ResponseEntity.ok(customerContactService.getAllCustomerContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerContact> getCustomerContactById(@PathVariable Long id) {
        return ResponseEntity.ok(customerContactService.getCustomerContactById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PostMapping
    public ResponseEntity<CustomerContact> createCustomerContact(@RequestBody CustomerContact customerContact) {
        return ResponseEntity.ok(customerContactService.createCustomerContact(customerContact));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerContact> updateCustomerContact(@PathVariable Long id, @RequestBody CustomerContact updateCustomerContact) {
        return ResponseEntity.ok(customerContactService.updateCustomerContact(id, updateCustomerContact));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EDITOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerContact(@PathVariable Long id) {
        customerContactService.deleteCustomerContact(id);
        return ResponseEntity.noContent().build();
    }
}