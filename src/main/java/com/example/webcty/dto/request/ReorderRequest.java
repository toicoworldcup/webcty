package com.example.webcty.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReorderRequest {
    @NotNull(message = "Id is required")
    private Long id;
}