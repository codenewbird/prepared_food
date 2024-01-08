package com.zjx.dao;

import com.zjx.entity.FoodException;
import com.zjx.pojo.FoodExceptionHash;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodExceptionDao extends BaseDao<FoodExceptionHash>{
    @Override
    int addItem(FoodExceptionHash item);
    List<FoodExceptionHash> queryItemById(String key);
}
