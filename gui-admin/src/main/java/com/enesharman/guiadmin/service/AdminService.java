package com.enesharman.guiadmin.service;

import com.enesharman.core.util.result.Result;
import com.enesharman.guiadmin.dto.AddFoodRequest;
import com.enesharman.guiadmin.dto.UpdateFoodRequest;

public interface AdminService {
    Result addFood(AddFoodRequest addFoodRequest);

    Result updateFood(UpdateFoodRequest updateFoodRequest);

    Result delete(long id);
}
