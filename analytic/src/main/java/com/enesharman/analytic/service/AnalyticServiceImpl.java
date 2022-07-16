package com.enesharman.analytic.service;

import com.enesharman.analytic.repository.FoodRepository;
import com.enesharman.core.config.KafkaEvents.FoodEvent;
import org.springframework.stereotype.Service;

@Service
public class AnalyticServiceImpl implements AnalyticService{
    private FoodRepository foodRepository;

    public AnalyticServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void analizeFood(FoodEvent foodEvent) {

    }
}
