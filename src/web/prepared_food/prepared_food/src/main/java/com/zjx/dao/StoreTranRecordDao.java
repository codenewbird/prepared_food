package com.zjx.dao;

import com.zjx.pojo.StoreTranRecord;

import java.util.List;

public interface StoreTranRecordDao extends BaseDao<StoreTranRecord>{

    @Override
    int addItem(StoreTranRecord item);

    List<StoreTranRecord> getAllItems();

    int getHash(String lot);
}
