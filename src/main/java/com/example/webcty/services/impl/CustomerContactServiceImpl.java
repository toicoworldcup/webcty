package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CustomerContactRequest;
import com.example.webcty.dto.response.CustomerContactResponse;
import com.example.webcty.entities.CustomerContact;
import com.example.webcty.mapper.CustomerContactMapper;
import com.example.webcty.repositories.CustomerContactRepository;
import com.example.webcty.services.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {
    private final CustomerContactRepository customerContactRepository;
    private final CustomerContactMapper customerContactMapper;

    @Autowired
    public CustomerContactServiceImpl(CustomerContactRepository customerContactRepository, CustomerContactMapper customerContactMapper) {
        this.customerContactRepository = customerContactRepository;
        this.customerContactMapper = customerContactMapper;
    }

    @Override
    public List<CustomerContactResponse> getAllCustomerContacts() {
        return customerContactRepository.findAll().stream()
                .map(customerContactMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerContactResponse getCustomerContactById(Long id) {
        CustomerContact customerContact = customerContactRepository.findById(id).orElse(null);
        return customerContact != null ? customerContactMapper.toResponseDTO(customerContact) : null;
    }

    @Override
    public CustomerContactResponse createCustomerContact(CustomerContactRequest customerContactDTO) {
        CustomerContact customerContact = customerContactMapper.toEntity(customerContactDTO);
        CustomerContact savedcustomerContact = customerContactRepository.save(customerContact);
        return customerContactMapper.toResponseDTO(savedcustomerContact);
    }

    @Override
    public CustomerContactResponse updateCustomerContact(Long id, CustomerContactRequest updatedCustomerContactDTO) {
        CustomerContact customerContact = customerContactRepository.findById(id).orElse(null);
        if (customerContact != null) {
            customerContact.setName(updatedCustomerContactDTO.getName());
            customerContact.setEmail(updatedCustomerContactDTO.getEmail());
            customerContact.setPhone(updatedCustomerContactDTO.getPhone());
            customerContact.setMessage(updatedCustomerContactDTO.getMessage());
            customerContact.setStatus(updatedCustomerContactDTO.getStatus());
            CustomerContact updatedCustomerContact = customerContactRepository.save(customerContact);
            return customerContactMapper.toResponseDTO(updatedCustomerContact);
        }
        return null;
    }

    @Override
    public void deleteCustomerContact(Long id) {
        customerContactRepository.deleteById(id);
    }
}
