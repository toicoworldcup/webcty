package com.example.webcty.dto.response;

import com.example.webcty.enums.MediaType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MediaFileResponse {
    private Long id;
    private MediaType entityType;
    private Long entityId;
    private String fileName;
    private String filePath;
    private String fileType;
    private Integer fileSize;
    private String url;
}
