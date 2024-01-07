package com.zjx.dao;

import com.zjx.entity.Equipment;
import com.zjx.entity.ProductionLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 周锦兴
 */
@Mapper
public interface EquipmentDao extends BaseDao<Equipment>{
    @Override
    int addItem(Equipment item);

    @Override
    List<Equipment> getAllItems(String key);
}
