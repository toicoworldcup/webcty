package com.example.webcty.services;

import com.example.webcty.dto.request.ProjectRequest;
import com.example.webcty.dto.response.ProjectResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectResponse> getAllProject();

    ProjectResponse getProjectById(Long id);

    ProjectResponse createProject(ProjectRequest project);

    ProjectResponse updateProject(Long id, ProjectRequest updatedProject);

    void deleteProject(Long id);
}
