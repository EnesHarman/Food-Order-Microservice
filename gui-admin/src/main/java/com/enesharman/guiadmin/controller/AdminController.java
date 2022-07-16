package com.enesharman.guiadmin.controller;

import com.enesharman.core.util.result.Result;
import com.enesharman.guiadmin.dto.AddFoodRequest;
import com.enesharman.guiadmin.dto.UpdateFoodRequest;
import com.enesharman.guiadmin.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gui-admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/food/add")
    public ResponseEntity<String> addFood(@RequestBody AddFoodRequest addFoodRequest){
        Result result = this.adminService.addFood(addFoodRequest);
        if(result.getResult()){
            return ResponseEntity.ok(result.getMessage());
        }
        return ResponseEntity.badRequest().body(result.getMessage());
    }

    @PutMapping("/food/update")
    public ResponseEntity<String> updateFood(@RequestBody UpdateFoodRequest updateFoodRequest){
        Result result = this.adminService.updateFood(updateFoodRequest);
        if(result.getResult()){
            return ResponseEntity.ok(result.getMessage());
        }
        return ResponseEntity.badRequest().body(result.getMessage());
    }

    @DeleteMapping("/food/delete/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable long id){
        Result result = this.adminService.delete(id);
        if(result.getResult()){
            return ResponseEntity.ok(result.getMessage());
        }
        return ResponseEntity.badRequest().body(result.getMessage());
    }
}
