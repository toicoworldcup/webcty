package com.example.webcty.mapper;

import com.example.webcty.dto.request.CustomerContactRequest;
import com.example.webcty.dto.response.CustomerContactResponse;
import com.example.webcty.entities.contactPage.CustomerContact;
import org.springframework.stereotype.Component;

@Component
public class CustomerContactMapper {
    public CustomerContact toEntity(CustomerContactRequest dto) {
        CustomerContact customerContact = new CustomerContact();
        customerContact.setName(dto.getName());
        customerContact.setEmail(dto.getEmail());
        customerContact.setPhone(dto.getPhone());
        customerContact.setMessage(dto.getMessage());
        customerContact.setStatus(dto.getStatus());
        return customerContact;
    }

    public CustomerContactResponse toResponseDTO(CustomerContact entity) {
        CustomerContactResponse dto = new CustomerContactResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setMessage(entity.getMessage());
        dto.setStatus(entity.getStatus());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }
}