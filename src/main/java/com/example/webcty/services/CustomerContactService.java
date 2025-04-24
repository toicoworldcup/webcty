package com.example.webcty.services;


import com.example.webcty.dto.request.CustomerContactRequest;
import com.example.webcty.dto.response.CustomerContactResponse;

import java.util.List;

public interface CustomerContactService {
    List<CustomerContactResponse> getAllCustomerContacts();

    CustomerContactResponse getCustomerContactById(Long id);

    CustomerContactResponse createCustomerContact(CustomerContactRequest customerContact);

    CustomerContactResponse updateCustomerContact(Long id, CustomerContactRequest updatedCustomerContact);

    void deleteCustomerContact(Long id);
}
