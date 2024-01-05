package com.zjx.dao;

import com.zjx.entity.Procedure;

/**
 * @author 周锦兴
 */
public interface ProcedureDao extends BaseDao<Procedure>{
    @Override
    int addItem(Procedure item);

    @Override
    int updateItem(Procedure item);

    @Override
    int deleteItem(Procedure item);
}
