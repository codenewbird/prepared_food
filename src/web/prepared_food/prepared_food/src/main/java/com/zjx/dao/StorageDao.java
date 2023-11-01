package com.zjx.dao;

import com.zjx.pojo.StorageRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageDao {
    StorageRecord getHash(String hash);
}
