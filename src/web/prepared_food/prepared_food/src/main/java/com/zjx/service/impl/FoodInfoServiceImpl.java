package com.zjx.service.impl;

import com.zjx.dao.*;
import com.zjx.entity.*;
import com.zjx.service.FoodInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Resource
    RawMaterialRuleDao rawMaterialRuleDao;
    @Override
    public int addFood(FoodInfo foodInfo) {
        baseInfoDao.addItem(foodInfo.getBaseInfo());
        rawMaterialDao.addItem(foodInfo.getRawMaterial());
        ingredientDao.addItem(foodInfo.getIngredient());
        nutritionDao.addItem(foodInfo.getNutrition());
        for(Procedure item : foodInfo.getProcedures()){
            procedureDao.addItem(item);
        }
        rawMaterialRuleDao.addItem(foodInfo.getRawMaterialRule());
        return 1;
    }

    @Override
    public List<BaseInfo> getAllFoods() {
        return baseInfoDao.getAllItems();
    }
}
