package com.example.webcty.services.impl;

import com.example.webcty.dto.request.ProjectBannerRequest;
import com.example.webcty.dto.response.ProjectBannerResponse;
import com.example.webcty.entities.projectPage.ProjectBanner;
import com.example.webcty.mapper.ProjectBannerMapper;
import com.example.webcty.repositories.ProjectBannerRepository;
import com.example.webcty.services.ProjectBannerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectBannerServiceImpl implements ProjectBannerService {
    private final ProjectBannerRepository projectBannerRepository;
    private final ProjectBannerMapper projectBannerMapper;

    @Autowired
    public ProjectBannerServiceImpl(ProjectBannerRepository projectBannerRepository, ProjectBannerMapper projectBannerMapper) {
        this.projectBannerRepository = projectBannerRepository;
        this.projectBannerMapper = projectBannerMapper;
    }

    @Override
    public List<ProjectBannerResponse> getAllProjectBanner() {
        return projectBannerRepository.findAll().stream()
                .map(projectBannerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectBannerResponse getProjectBannerById(Long id) {
        ProjectBanner projectBanner = projectBannerRepository.findById(id).orElse(null);
        return projectBanner != null ? projectBannerMapper.toResponseDTO(projectBanner) : null;
    }

    @Override
    @Transactional
    public ProjectBannerResponse createProjectBanner(ProjectBannerRequest projectBannerDTO) {
        projectBannerRepository.deleteAll();
        ProjectBanner projectBanner = projectBannerMapper.toEntity(projectBannerDTO);
        ProjectBanner savedProjectBanner = projectBannerRepository.save(projectBanner);
        return projectBannerMapper.toResponseDTO(savedProjectBanner);
    }

    @Override
    public ProjectBannerResponse updateProjectBanner(Long id, ProjectBannerRequest updatedProjectBannerDTO) {
        ProjectBanner projectBanner = projectBannerRepository.findById(id).orElse(null);
        if (projectBanner != null) {
            projectBanner.setSlogan(updatedProjectBannerDTO.getSlogan());
            projectBanner.setImage(updatedProjectBannerDTO.getImage());
            ProjectBanner updatedProjectBanner = projectBannerRepository.save(projectBanner);
            return projectBannerMapper.toResponseDTO(updatedProjectBanner);
        }
        return null;
    }

    @Override
    public void deleteProjectBanner(Long id) {
        projectBannerRepository.deleteById(id);
    }
}
