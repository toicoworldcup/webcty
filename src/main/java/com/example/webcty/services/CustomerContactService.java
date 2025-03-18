package com.example.webcty.services;

import com.example.webcty.entities.CustomerContact;
import com.example.webcty.repositories.CustomerContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerContactService {
    @Autowired
    private CustomerContactRepository customerContactRepository;

    public List<CustomerContact> getAllCustomerContacts() {
        return customerContactRepository.findAll();
    }

    public CustomerContact getCustomerContactById(Long id) {
        return customerContactRepository.findById(id).orElse(null);
    }

    public CustomerContact createCustomerContact(CustomerContact customerContact) {
        return customerContactRepository.save(customerContact);
    }

    public CustomerContact updateCustomerContact(Long id, CustomerContact updatedCustomerContact) {
        CustomerContact customerContact = getCustomerContactById(id);
        customerContact.setName(updatedCustomerContact.getName());
        customerContact.setEmail(updatedCustomerContact.getEmail());
        customerContact.setPhone(updatedCustomerContact.getPhone());
        customerContact.setMessage(updatedCustomerContact.getMessage());
        customerContact.setStatus(updatedCustomerContact.getStatus());
        return customerContactRepository.save(customerContact);
    }

    public void deleteCustomerContact(Long id) {
        customerContactRepository.deleteById(id);
    }
}
