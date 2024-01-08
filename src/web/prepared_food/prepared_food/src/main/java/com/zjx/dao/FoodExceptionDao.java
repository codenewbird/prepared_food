package com.zjx.dao;

import com.zjx.entity.FoodException;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodExceptionDao extends BaseDao<FoodException>{
    @Override
    int addItem(FoodException item);
}
