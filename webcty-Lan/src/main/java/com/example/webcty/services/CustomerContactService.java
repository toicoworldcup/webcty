package com.example.webcty.services;

import com.example.webcty.dto.request.CustomerContactRequest;
import com.example.webcty.dto.response.CustomerContactResponse;

import java.util.List;

public interface CustomerContactService {
    List<CustomerContactResponse> getAllCustomerContacts();

    CustomerContactResponse getCustomerContactById(Long id);

    CustomerContactResponse createCustomerContact(CustomerContactRequest request);

    CustomerContactResponse updateCustomerContact(Long id, CustomerContactRequest request);

    void deleteCustomerContact(Long id);
}