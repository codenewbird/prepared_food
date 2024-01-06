package com.zjx.dao;

import com.zjx.entity.Procedure;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 周锦兴
 */
@Mapper
public interface ProcedureDao extends BaseDao<Procedure>{
    @Override
    int addItem(Procedure item);


}
