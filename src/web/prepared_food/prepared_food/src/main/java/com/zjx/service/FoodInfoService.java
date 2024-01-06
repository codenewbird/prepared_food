package com.zjx.service;

import com.zjx.entity.BaseInfo;
import com.zjx.entity.FoodInfo;

import java.util.List;

/**
 * @author 周锦兴
 */
public interface FoodInfoService {
    int addFood(FoodInfo foodInfo);

    List<BaseInfo> getAllFoods();
}
