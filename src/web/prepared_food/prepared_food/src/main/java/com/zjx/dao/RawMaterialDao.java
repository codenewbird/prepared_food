package com.zjx.dao;

import com.zjx.entity.RawMaterial;

/**
 * @author 周锦兴
 */
public interface RawMaterialDao extends BaseDao<RawMaterial>{
    @Override
    int addItem(RawMaterial item);

    @Override
    int updateItem(RawMaterial item);

    @Override
    int deleteItem(RawMaterial item);
}
