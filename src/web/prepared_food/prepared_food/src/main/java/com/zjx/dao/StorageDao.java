package com.zjx.dao;

import com.zjx.pojo.StorageRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StorageDao {
    List<StorageRecord> getHash(String hash);
}
