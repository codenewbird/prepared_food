package com.zjx.dao;

import com.zjx.entity.Equipment;
import com.zjx.entity.ProductionLine;

import java.util.List;

/**
 * @author 周锦兴
 */
public interface EquipmentDao extends BaseDao<Equipment>{
    @Override
    int addItem(Equipment item);

    @Override
    List<Equipment> getAllItems(String key);
}
