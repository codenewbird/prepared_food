package com.zjx.service.impl;

import com.zjx.dao.*;
import com.zjx.entity.FoodInfo;
import com.zjx.entity.Ingredient;
import com.zjx.entity.Nutrition;
import com.zjx.entity.Procedure;
import com.zjx.service.FoodInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author 周锦兴
 */
@Service
public class FoodInfoServiceImpl implements FoodInfoService {
    @Resource
    BaseInfoDao baseInfoDao;
    @Resource
    RawMaterialDao rawMaterialDao;
    @Resource
    IngredientDao ingredientDao;
    @Resource
    NutritionDao nutritionDao;
    @Resource
    ProcedureDao procedureDao;
    @Override
    public int addFood(FoodInfo foodInfo) {
        baseInfoDao.addItem(foodInfo.getBaseInfo());
        rawMaterialDao.addItem(foodInfo.getRawMaterial());
        ingredientDao.addItem(foodInfo.getIngredient());
        nutritionDao.addItem(foodInfo.getNutrition());
        procedureDao.addItem(foodInfo.getProcedure());
        return 0;
    }
}
