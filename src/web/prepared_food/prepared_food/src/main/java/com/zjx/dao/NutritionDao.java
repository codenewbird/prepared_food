package com.zjx.dao;

import com.zjx.entity.Nutrition;

/**
 * @author 周锦兴
 */
public interface NutritionDao extends BaseDao<Nutrition>{
    @Override
    int addItem(Nutrition item);

    @Override
    int updateItem(Nutrition item);

    @Override
    int deleteItem(Nutrition item);
}
