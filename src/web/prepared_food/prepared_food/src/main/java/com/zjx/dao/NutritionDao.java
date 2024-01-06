package com.zjx.dao;

import com.zjx.entity.Nutrition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 周锦兴
 */
@Mapper
public interface NutritionDao extends BaseDao<Nutrition>{
    @Override
    int addItem(Nutrition item);


}
