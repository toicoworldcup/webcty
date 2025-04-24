package com.example.webcty.services;


import com.example.webcty.dto.request.TechnologyRequest;
import com.example.webcty.dto.response.TechnologyResponse;

import java.util.List;

public interface TechnologyService {
    List<TechnologyResponse> getAllTechnologys();

    TechnologyResponse getTechnologyById(Long id);

    TechnologyResponse createTechnology(TechnologyRequest technology);

    TechnologyResponse updateTechnology(Long id, TechnologyRequest updatedTechnology);

    void deleteTechnology(Long id);
}
