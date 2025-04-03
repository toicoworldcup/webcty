package com.example.webcty.dto.request;

import com.example.webcty.enums.MediaType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MediaFileRequest {
    private MediaType entityType;
    private Long entityId;
    private String fileName;
    private String filePath;
    private String fileType;
    private Integer fileSize;
    private String url;
}
