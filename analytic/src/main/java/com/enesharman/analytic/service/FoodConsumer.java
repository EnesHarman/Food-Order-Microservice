package com.enesharman.analytic.service;

import com.enesharman.core.config.KafkaEvents.FoodEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FoodConsumer {
    private final AnalyticService analyticService;

    public FoodConsumer(AnalyticService analyticService) {
        this.analyticService = analyticService;
    }

    @KafkaListener(topics = "food", groupId = "analyticService")
    public void listenFood(FoodEvent foodEvent){
        analyticService.analizeFood(foodEvent);
        return;
    }
}
