package com.zjx.dao;

import com.zjx.entity.ProductionLine;

import java.util.List;

/**
 * @author 周锦兴
 */
public interface LineDao extends BaseDao<ProductionLine>{
    @Override
    int addItem(ProductionLine item);

    @Override
    List<ProductionLine> getAllItems();
}
