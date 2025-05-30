package com.example.webcty.services;

import com.example.webcty.dto.request.ProjectComponentRequest;
import com.example.webcty.dto.response.ProjectComponentResponse;

import java.util.List;

public interface ProjectComponentService {
    List<ProjectComponentResponse> getAllProjectComponent();

    ProjectComponentResponse getProjectComponentById(Long id);

    ProjectComponentResponse createProjectComponent(ProjectComponentRequest projectComponent);

    ProjectComponentResponse updateProjectComponent(Long id, ProjectComponentRequest updatedProjectComponent);

    void deleteProjectComponent(Long id);
}
