package com.example.webcty.services;

import com.example.webcty.dto.request.ProjectBannerRequest;
import com.example.webcty.dto.response.ProjectBannerResponse;

import java.util.List;

public interface ProjectBannerService {
    List<ProjectBannerResponse> getAllProjectBanner();

    ProjectBannerResponse getProjectBannerById(Long id);

    ProjectBannerResponse createProjectBanner(ProjectBannerRequest projectBanner);

    ProjectBannerResponse updateProjectBanner(Long id, ProjectBannerRequest updatedProjectBanner);

    void deleteProjectBanner(Long id);
}
