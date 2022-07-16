package com.enesharman.food.service;

import com.enesharman.core.config.KafkaEvents.FoodEvent;

public interface FoodService {

    void addFood(FoodEvent foodEvent);

    void deleteFood(FoodEvent foodEvent);

    void updateFood(FoodEvent foodEvent);
}
