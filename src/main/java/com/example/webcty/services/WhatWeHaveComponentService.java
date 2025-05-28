package com.example.webcty.services;

import com.example.webcty.dto.request.WhatWeHaveComponentRequest;
import com.example.webcty.dto.response.WhatWeHaveComponentResponse;

import java.util.List;

public interface WhatWeHaveComponentService {
    List<WhatWeHaveComponentResponse> getAllWhatWeHave();

    WhatWeHaveComponentResponse getWhatWeHaveById(Long id);

    WhatWeHaveComponentResponse createWhatWeHave(WhatWeHaveComponentRequest WhatWeHave);

    WhatWeHaveComponentResponse updateWhatWeHave(Long id, WhatWeHaveComponentRequest updatedWhatWeHave);

    void deleteWhatWeHave(Long id);
}
