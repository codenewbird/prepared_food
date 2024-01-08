package com.zjx.service.impl;

import com.zjx.dao.StoreTranRecordDao;
import com.zjx.entity.StoreTranItem;
import com.zjx.pojo.StoreTranRecord;
import com.zjx.service.StoreTranItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreTranItemServiceImpl implements StoreTranItemService {

    private StoreTranRecordDao storeTranRecordDao;
    @Override
    public int addRecord(StoreTranItem item) {
        return 1;
    }

    @Override
    public List<StoreTranRecord> getAllRecords() {
        return storeTranRecordDao.getAllItems();
    }
}
