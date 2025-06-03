package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CustomerContactRequest;
import com.example.webcty.dto.response.CustomerContactResponse;
import com.example.webcty.entities.contactPage.CustomerContact;
import com.example.webcty.mapper.CustomerContactMapper;
import com.example.webcty.repositories.CustomerContactRepository;
import com.example.webcty.services.CustomerContactService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {
    private final CustomerContactRepository customerContactRepository;
    private final CustomerContactMapper customerContactMapper;
    private final JavaMailSender mailSender;

    @Autowired
    public CustomerContactServiceImpl(CustomerContactRepository customerContactRepository, CustomerContactMapper customerContactMapper, JavaMailSender mailSender) {
        this.customerContactRepository = customerContactRepository;
        this.customerContactMapper = customerContactMapper;
        this.mailSender = mailSender;
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
        CustomerContact savedCustomerContact = customerContactRepository.save(customerContact);
        sendCustomerContactNotification(savedCustomerContact);
        return customerContactMapper.toResponseDTO(savedCustomerContact);
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

    public void sendCustomerContactNotification(CustomerContact contact) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo("lanno442@gmail.com");
            helper.setSubject("Liên hệ mới từ khách hàng");
            helper.setFrom("chilannguyen2004@gmail.com");

            String content = "<p>Bạn nhận được một liên hệ mới:</p>" +
                    "<p><strong>Họ tên:</strong> " + contact.getName() + "</p>" +
                    "<p><strong>Email:</strong> " + contact.getEmail() + "</p>" +
                    "<p><strong>SĐT:</strong> " + contact.getPhone() + "</p>" +
                    "<p><strong>Nội dung:</strong><br>" + contact.getMessage() + "</p>" +
                    "<br><p>Vui lòng đăng nhập CMS để xử lý.</p>";

            helper.setText(content, true);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
