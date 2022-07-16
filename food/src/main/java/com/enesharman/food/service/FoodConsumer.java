package com.enesharman.food.service;

import com.enesharman.core.config.KafkaEvents.FoodEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FoodConsumer {
    FoodService foodService;

    public FoodConsumer(FoodService foodService) {
        this.foodService = foodService;
    }

    @KafkaListener(topics = "food", groupId = "foodService")
    public void listenFood(FoodEvent foodEvent){
        switch (foodEvent.getCrudEvent()){
            case ADD -> {
                foodService.addFood(foodEvent);
                break;
            }
            case DELETE -> {
                foodService.deleteFood(foodEvent);
                break;
            }
            case UPDATE -> {
                foodService.updateFood(foodEvent);
                break;
            }
            default -> {
                log.error("Event Type is not valid.");
            }

        }
    }
}
