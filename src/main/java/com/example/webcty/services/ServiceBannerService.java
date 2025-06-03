package com.example.webcty.services;

import com.example.webcty.dto.request.ServiceBannerRequest;
import com.example.webcty.dto.response.ServiceBannerResponse;

import java.util.List;

public interface ServiceBannerService {
    List<ServiceBannerResponse> getAllServiceBanner();

    ServiceBannerResponse getServiceBannerById(Long id);

    ServiceBannerResponse createServiceBanner(ServiceBannerRequest serviceBanner);

    ServiceBannerResponse updateServiceBanner(Long id, ServiceBannerRequest updatedServiceBanner);

    void deleteServiceBanner(Long id);
}
