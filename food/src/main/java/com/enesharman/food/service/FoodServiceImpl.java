package com.enesharman.food.service;

import com.enesharman.core.config.KafkaEvents.FoodEvent;
import com.enesharman.core.model.Food;
import com.enesharman.food.repository.FoodRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService{
    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void addFood(FoodEvent foodEvent) {
        Food food = Food.builder()
                .name(foodEvent.getFood().getName())
                .picUrl(foodEvent.getFood().getPicUrl())
                .description(foodEvent.getFood().getDescription())
                .build();
        this.foodRepository.save(food);
    }

    @Override
    public void deleteFood(FoodEvent foodEvent) {
        this.foodRepository.deleteById(foodEvent.getFood().getId());
    }

    @Override
    public void updateFood(FoodEvent foodEvent) {
        Food food = Food.builder()
                .id(foodEvent.getFood().getId())
                .name(foodEvent.getFood().getName())
                .picUrl(foodEvent.getFood().getPicUrl())
                .description(foodEvent.getFood().getDescription())
                .build();
        this.foodRepository.save(food);
    }
}
