package com.example.webcty.services;

import com.example.webcty.dto.request.WhatWeHaveRequest;
import com.example.webcty.dto.response.WhatWeHaveResponse;

import java.util.List;

public interface WhatWeHaveService {
    List<WhatWeHaveResponse> getAllWhatWeHave();

    WhatWeHaveResponse getWhatWeHaveById(Long id);

    WhatWeHaveResponse createWhatWeHave(WhatWeHaveRequest whatWeHave);

    WhatWeHaveResponse updateWhatWeHave(Long id, WhatWeHaveRequest updatedWhatWeHave);

    void deleteWhatWeHave(Long id);
}
