package com.mpm.beforeandafter.image.dto;

import com.mpm.beforeandafter.image.model.Image;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateImageResponse {
    private long imageId;
    private String file;
    private Long categoryId;
    private String description;
    private Long userId;

    public static CreateImageResponse map(Image image) {
        return CreateImageResponse.builder()
                .imageId(image.getId())
                .file(image.getFile())
                .categoryId(image.getCategory().getCategoryId())
                .description(image.getDescription())
                .userId(image.getUser().getId())
                .build();
    }
}
