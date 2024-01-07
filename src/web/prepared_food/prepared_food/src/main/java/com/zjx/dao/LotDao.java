package com.zjx.dao;

import com.zjx.entity.ProductionLot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 周锦兴
 */
@Mapper
public interface LotDao extends BaseDao<ProductionLot>{
    @Override
    int addItem(ProductionLot item);

    @Override
    List<ProductionLot> getAllItems();
}
