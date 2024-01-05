package com.zjx.dao;

import com.zjx.entity.BaseInfo;

/**
 * @author 周锦兴
 */
public interface BaseInfoDao extends BaseDao<BaseInfo>{
    @Override
    int addItem(BaseInfo item);

    @Override
    int updateItem(BaseInfo item);

    @Override
    int deleteItem(BaseInfo item);
}
