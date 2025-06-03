package com.example.webcty.services;

import com.example.webcty.dto.request.NewsBannerRequest;
import com.example.webcty.dto.response.NewsBannerResponse;

import java.util.List;

public interface NewsBannerService {
    List<NewsBannerResponse> getAllNewsBanner();

    NewsBannerResponse getNewsBannerById(Long id);

    NewsBannerResponse createNewsBanner(NewsBannerRequest newsBanner);

    NewsBannerResponse updateNewsBanner(Long id, NewsBannerRequest updatedNewsBanner);

    void deleteNewsBanner(Long id);
}
