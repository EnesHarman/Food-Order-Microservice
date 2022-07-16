package com.enesharman.analytic.service;

import com.enesharman.core.config.KafkaEvents.FoodEvent;

public interface AnalyticService {
    void analizeFood(FoodEvent foodEvent);
}
