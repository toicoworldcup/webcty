package com.example.webcty.services.impl;

import com.example.webcty.dto.request.CompanyManagerComponentRequest;
import com.example.webcty.dto.request.ReorderRequest;
import com.example.webcty.dto.response.CompanyManagerComponentResponse;
import com.example.webcty.entities.aboutUsPage.CompanyManagerComponent;
import com.example.webcty.mapper.CompanyManagerComponentMapper;
import com.example.webcty.repositories.CompanyManagerComponentRepository;
import com.example.webcty.services.CompanyManagerComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CompanyManagerComponentServiceImpl implements CompanyManagerComponentService {
    private final CompanyManagerComponentRepository companyManagerComponentRepository;
    private final CompanyManagerComponentMapper companyManagerComponentMapper;

    @Autowired
    public CompanyManagerComponentServiceImpl(CompanyManagerComponentRepository companyManagerComponentRepository, CompanyManagerComponentMapper companyManagerComponentMapper) {
        this.companyManagerComponentRepository = companyManagerComponentRepository;
        this.companyManagerComponentMapper = companyManagerComponentMapper;
    }

    @Override
    public List<CompanyManagerComponentResponse> getAllCompanyManagerComponent() {
        return companyManagerComponentRepository.findAll().stream()
                .map(companyManagerComponentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyManagerComponentResponse getCompanyManagerComponentById(Long id) {
        CompanyManagerComponent companyManagerComponent = companyManagerComponentRepository.findById(id).orElse(null);
        return companyManagerComponent != null ? companyManagerComponentMapper.toResponseDTO(companyManagerComponent) : null;
    }

    @Override
    @Transactional
    public CompanyManagerComponentResponse createCompanyManagerComponent(CompanyManagerComponentRequest companyManagerComponentDTO) {
        CompanyManagerComponent companyManagerComponent = companyManagerComponentMapper.toEntity(companyManagerComponentDTO);

        Integer maxOrder = companyManagerComponentRepository.findMaxOrderIndex();
        int nextOrder = (maxOrder != null ? maxOrder : 0) + 1;

        companyManagerComponent.setOrderIndex(nextOrder);

        CompanyManagerComponent savedCompanyManagerComponent = companyManagerComponentRepository.save(companyManagerComponent);
        return companyManagerComponentMapper.toResponseDTO(savedCompanyManagerComponent);
    }

    @Override
    public CompanyManagerComponentResponse updateCompanyManagerComponent(Long id, CompanyManagerComponentRequest updatedCompanyManagerComponentDTO) {
        CompanyManagerComponent companyManagerComponent = companyManagerComponentRepository.findById(id).orElse(null);
        if (companyManagerComponent != null) {
            companyManagerComponent.setName(updatedCompanyManagerComponentDTO.getName());
            companyManagerComponent.setPosition(updatedCompanyManagerComponentDTO.getPosition());
            companyManagerComponent.setDescription(updatedCompanyManagerComponentDTO.getDescription());
            companyManagerComponent.setImage(updatedCompanyManagerComponentDTO.getImage());
            CompanyManagerComponent updatedCompanyManagerComponent = companyManagerComponentRepository.save(companyManagerComponent);
            return companyManagerComponentMapper.toResponseDTO(updatedCompanyManagerComponent);
        }
        return null;
    }

    @Override
    public void deleteCompanyManagerComponent(Long id) {
        companyManagerComponentRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void reorderCompanyManagerComponent(List<ReorderRequest> reorderList) {
        List<Long> ids = reorderList.stream()
                .map(ReorderRequest::getId)
                .collect(Collectors.toList());

        List<CompanyManagerComponent> companyManagerComponentList = companyManagerComponentRepository.findAllById(ids);

        int tempIndex = -1;
        for (CompanyManagerComponent companyManagerComponent : companyManagerComponentList) {
            companyManagerComponent.setOrderIndex(tempIndex--);
        }
        companyManagerComponentRepository.saveAll(companyManagerComponentList);
        companyManagerComponentRepository.flush();

        Map<Long, CompanyManagerComponent> companyManagerComponentMap = companyManagerComponentList.stream()
                .collect(Collectors.toMap(CompanyManagerComponent::getId, n -> n));
        int index = 1;
        for (Long id : ids) {
            CompanyManagerComponent companyManagerComponent = companyManagerComponentMap.get(id);
            if (companyManagerComponent != null) {
                companyManagerComponent.setOrderIndex(index++);
            }
        }
        companyManagerComponentRepository.saveAll(companyManagerComponentList);
        companyManagerComponentRepository.flush();
    }
}
