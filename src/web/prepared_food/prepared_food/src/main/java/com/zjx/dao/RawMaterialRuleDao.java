package com.zjx.dao;

import com.zjx.entity.RawMaterialRule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 周锦兴
 */
@Mapper
public interface RawMaterialRuleDao extends BaseDao<RawMaterialRule>{
    @Override
    int addItem(RawMaterialRule item);

}
