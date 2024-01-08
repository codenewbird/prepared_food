package com.zjx.service;

import com.zjx.entity.StoreTranItem;
import com.zjx.pojo.StoreTranRecord;


import java.util.List;

public interface StoreTranItemService {
    int addRecord(StoreTranItem item);

    List<StoreTranRecord> getAllRecords();
}
