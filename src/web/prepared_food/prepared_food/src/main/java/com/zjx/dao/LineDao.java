package com.zjx.dao;

import com.zjx.entity.ProductionLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 周锦兴
 */
@Mapper
public interface LineDao extends BaseDao<ProductionLine>{
    @Override
    int addItem(ProductionLine item);

    @Override
    List<ProductionLine> getAllItems();
}
