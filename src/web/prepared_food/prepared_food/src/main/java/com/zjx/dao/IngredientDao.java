package com.zjx.dao;

import com.zjx.entity.Ingredient;

/**
 * @author 周锦兴
 */
public interface IngredientDao extends BaseDao<Ingredient>{
    @Override
    int addItem(Ingredient item);

    @Override
    int updateItem(Ingredient item);

    @Override
    int deleteItem(Ingredient item);
}
