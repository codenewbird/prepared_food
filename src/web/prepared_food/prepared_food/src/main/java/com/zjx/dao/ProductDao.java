package com.zjx.dao;

import com.zjx.pojo.ProductRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {
    ProductRecord getHash(String batch);
}
