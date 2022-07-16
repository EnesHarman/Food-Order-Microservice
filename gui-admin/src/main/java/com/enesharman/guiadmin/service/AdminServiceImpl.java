package com.enesharman.guiadmin.service;

import com.enesharman.core.config.KafkaEventTypes.FoodEvents;
import com.enesharman.core.config.KafkaEvents.FoodEvent;
import com.enesharman.core.model.Food;
import com.enesharman.core.util.result.Result;
import com.enesharman.core.util.result.SuccessResult;
import com.enesharman.guiadmin.dto.AddFoodRequest;
import com.enesharman.guiadmin.dto.UpdateFoodRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService{

    @Value("${kafka.topics.food}")
    private String foodTopic;

    @Value("${kafka.topics.analytic}")
    private String analyticTopic;
    final KafkaTemplate<String, FoodEvent> foodKafkaTemplate;

    public AdminServiceImpl(KafkaTemplate<String, FoodEvent> foodKafkaTemplate) {
        this.foodKafkaTemplate = foodKafkaTemplate;
    }

    @Override
    public Result addFood(AddFoodRequest addFoodRequest) {
        Food food = Food.builder()
                .name(addFoodRequest.getName())
                .picUrl(addFoodRequest.getPictureUrl())
                .description(addFoodRequest.getDescription())
                .build();
        FoodEvent foodEvent= FoodEvent.builder()
                .food(food)
                .crudEvent(FoodEvents.ADD)
                .build();

        ListenableFuture<SendResult<String, FoodEvent>> future =
                foodKafkaTemplate.send(foodTopic, foodEvent);

        future.addCallback(new ListenableFutureCallback<SendResult<String, FoodEvent>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Food add event can not send to kafka. Error: ", ex);
            }

            @Override
            public void onSuccess(SendResult<String, FoodEvent> result) {
                log.info("Food add event has been sent to kafka.");
            }
        });

        ListenableFuture<SendResult<String, FoodEvent>> analyticFuture =
                foodKafkaTemplate.send(foodTopic, foodEvent);

        analyticFuture.addCallback(new ListenableFutureCallback<SendResult<String, FoodEvent>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Food analytic event can not send to kafka. Error: ", ex);
            }

            @Override
            public void onSuccess(SendResult<String, FoodEvent> result) {
                log.info("Food analytic event has been sent to kafka.");
            }
        });

        return new SuccessResult("Food added.");
    }

    @Override
    public Result updateFood(UpdateFoodRequest updateFoodRequest) {
        Food food = Food.builder()
                .name(updateFoodRequest.getName())
                .picUrl(updateFoodRequest.getPictureUrl())
                .description(updateFoodRequest.getDescription())
                .build();
        FoodEvent foodEvent = FoodEvent.builder()
                .food(food)
                .crudEvent(FoodEvents.UPDATE)
                .build();

        ListenableFuture<SendResult<String, FoodEvent>> future =
                foodKafkaTemplate.send(foodTopic, foodEvent);

        future.addCallback(new ListenableFutureCallback<SendResult<String, FoodEvent>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Food update event can not send to kafka. Error: ", ex);
            }

            @Override
            public void onSuccess(SendResult<String, FoodEvent> result) {
                log.info("Food update event has been sent to kafka.");
            }
        });
        return new SuccessResult("Food updated.");
    }

    @Override
    public Result delete(long id) {
        Food food = Food.builder()
                .id(id)
                .build();
        FoodEvent foodEvent = FoodEvent.builder()
                .food(food)
                .crudEvent(FoodEvents.DELETE)
                .build();

        ListenableFuture<SendResult<String, FoodEvent>> future =
                foodKafkaTemplate.send(foodTopic, foodEvent);

        future.addCallback(new ListenableFutureCallback<SendResult<String, FoodEvent>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Food delete event can not send to kafka. Error: ", ex);
            }

            @Override
            public void onSuccess(SendResult<String, FoodEvent> result) {
                log.info("Food delete event has been sent to kafka.");
            }
        });
        return new SuccessResult("Food deleted.");
    }
}
