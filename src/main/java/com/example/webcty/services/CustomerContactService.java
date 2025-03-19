package com.example.webcty.services;

import com.example.webcty.entities.CustomerContact;

import java.util.List;

public interface CustomerContactService {
    List<CustomerContact> getAllCustomerContacts();

    CustomerContact getCustomerContactById(Long id);

    CustomerContact createCustomerContact(CustomerContact customerContact);

    CustomerContact updateCustomerContact(Long id, CustomerContact updatedCustomerContact);

    void deleteCustomerContact(Long id);
}
