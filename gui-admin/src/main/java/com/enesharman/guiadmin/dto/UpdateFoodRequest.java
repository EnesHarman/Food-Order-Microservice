package com.enesharman.guiadmin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UpdateFoodRequest {
    private String name;
    private String pictureUrl;
    private String description;
}
