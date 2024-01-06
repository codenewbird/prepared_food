package com.zjx.dao;

import com.zjx.entity.BaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 周锦兴
 */
@Mapper
public interface BaseInfoDao extends BaseDao<BaseInfo>{
    @Override
    int addItem(BaseInfo item);

    List<BaseInfo> getAllItems();
}
