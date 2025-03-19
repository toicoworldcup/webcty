package com.example.webcty.services.impl;

import com.example.webcty.entities.CustomerContact;
import com.example.webcty.repositories.CustomerContactRepository;
import com.example.webcty.services.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {
    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Override
    public List<CustomerContact> getAllCustomerContacts() {
        return customerContactRepository.findAll();
    }

    @Override
    public CustomerContact getCustomerContactById(Long id) {
        return customerContactRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerContact createCustomerContact(CustomerContact customerContact) {
        return customerContactRepository.save(customerContact);
    }

    @Override
    public CustomerContact updateCustomerContact(Long id, CustomerContact updatedCustomerContact) {
        CustomerContact customerContact = getCustomerContactById(id);
        customerContact.setName(updatedCustomerContact.getName());
        customerContact.setEmail(updatedCustomerContact.getEmail());
        customerContact.setPhone(updatedCustomerContact.getPhone());
        customerContact.setMessage(updatedCustomerContact.getMessage());
        customerContact.setStatus(updatedCustomerContact.getStatus());
        return customerContactRepository.save(customerContact);
    }

    @Override
    public void deleteCustomerContact(Long id) {
        customerContactRepository.deleteById(id);
    }
}
