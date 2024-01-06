package com.zjx.dao;

import com.zjx.pojo.ProductRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 周锦兴
 */
@Mapper
public interface ProductDao {
    ProductRecord getHash(String batch);
}
