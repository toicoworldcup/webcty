package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CustomerContactRequest;
import com.example.webcty.dto.response.CustomerContactResponse;
import com.example.webcty.entities.CustomerContact;
import com.example.webcty.repositories.CustomerContactRepository;
import com.example.webcty.services.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {
    private final CustomerContactRepository customerContactRepository;

    @Autowired
    public CustomerContactServiceImpl(CustomerContactRepository customerContactRepository) {
        this.customerContactRepository = customerContactRepository;
    }

    private CustomerContactResponse convertToResponse(CustomerContact customerContact) {
        CustomerContactResponse response = new CustomerContactResponse();
        response.setId(customerContact.getId());
        response.setName(customerContact.getName());
        response.setEmail(customerContact.getEmail());
        response.setPhone(customerContact.getPhone());
        response.setMessage(customerContact.getMessage());
        response.setStatus(customerContact.getStatus());
        return response;
    }

    private CustomerContact convertToEntity(CustomerContactRequest request) {
        CustomerContact customerContact = new CustomerContact();
        customerContact.setName(request.getName());
        customerContact.setEmail(request.getEmail());
        customerContact.setPhone(request.getPhone());
        customerContact.setMessage(request.getMessage());
        customerContact.setStatus(request.getStatus());
        return customerContact;
    }

    @Override
    public List<CustomerContactResponse> getAllCustomerContacts() {
        return customerContactRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public CustomerContactResponse getCustomerContactById(Long id) {
        return customerContactRepository.findById(id).map(this::convertToResponse).orElseThrow(() -> new RuntimeException("CustomerContact not found"));
    }

    @Override
    public CustomerContactResponse createCustomerContact(CustomerContactRequest request) {
        CustomerContact newCustomerContact = convertToEntity(request);
        CustomerContact savedCustomerContact = customerContactRepository.save(newCustomerContact);
        return convertToResponse(savedCustomerContact);
    }

    @Override
    public CustomerContactResponse updateCustomerContact(Long id, CustomerContactRequest request) {
        CustomerContact existingCustomerContact = customerContactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CustomerContact not found"));

        existingCustomerContact.setName(request.getName());
        existingCustomerContact.setEmail(request.getEmail());
        existingCustomerContact.setPhone(request.getPhone());
        existingCustomerContact.setMessage(request.getMessage());
        existingCustomerContact.setStatus(request.getStatus());

        CustomerContact updatedCustomerContact = customerContactRepository.save(existingCustomerContact);
        return convertToResponse(updatedCustomerContact);
    }

    @Override
    public void deleteCustomerContact(Long id) {
        if (!customerContactRepository.existsById(id)) {
            throw new RuntimeException("CustomerContact not found");
        }
        customerContactRepository.deleteById(id);
    }
}