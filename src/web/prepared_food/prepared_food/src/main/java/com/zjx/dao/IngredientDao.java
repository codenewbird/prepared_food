package com.zjx.dao;

import com.zjx.entity.Ingredient;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 周锦兴
 */
@Mapper
public interface IngredientDao extends BaseDao<Ingredient>{
    @Override
    int addItem(Ingredient item);

}
