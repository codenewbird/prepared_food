package com.zjx.dao;

import com.zjx.entity.RawMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 周锦兴
 */
@Mapper
public interface RawMaterialDao extends BaseDao<RawMaterial>{
    @Override
    int addItem(RawMaterial item);


}
