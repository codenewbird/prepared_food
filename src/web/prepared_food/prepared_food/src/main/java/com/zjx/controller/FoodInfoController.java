package com.zjx.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjx.entity.BaseInfo;
import com.zjx.entity.FoodInfo;
import com.zjx.service.FoodInfoService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周锦兴
 */
@RestController
@RequestMapping("food")
public class FoodInfoController {
    @Resource
    private FoodInfoService foodInfoService;
    @PostMapping("add")
    public ResponseEntity<FoodInfo> addFood(@RequestBody FoodInfo foodInfo) throws JsonProcessingException {
//        System.out.println("addSuccess");
//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(objectMapper.writeValueAsString(foodInfo));
        foodInfoService.addFood(foodInfo);
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping("getAllFood")
    public ResponseEntity<List<BaseInfo>> getAllFood(){
        List<BaseInfo> infos = new ArrayList<>();
        infos = foodInfoService.getAllFoods();
        return ResponseEntity.ok().body(infos);
    }

    @RequestMapping("{identificationCode}")
    public ResponseEntity<BaseInfo> getFoodInfo(@PathVariable("identificationCode") String id){
        BaseInfo baseInfo = foodInfoService.getFoodInfo(id);
        return ResponseEntity.ok().body(baseInfo);
    }

}
