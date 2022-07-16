package com.enesharman.core.config.KafkaEvents;

import com.enesharman.core.config.KafkaEventTypes.FoodEvents;
import com.enesharman.core.model.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodEvent {
    private Food food;
    private FoodEvents crudEvent;
}
