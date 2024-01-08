package com.zjx.service.impl;

import com.zjx.dao.BlockChainDAO;
import com.zjx.dao.FoodExceptionDao;
import com.zjx.entity.FoodException;
import com.zjx.pojo.FoodExceptionHash;
import com.zjx.service.FoodExceptionService;
import jakarta.annotation.Resource;

import java.util.List;

public class FoodExpSvcImpl implements FoodExceptionService {
    @Resource
    private BlockChainDAO blockChainDAO;
    @Resource
    private FoodExceptionDao foodExceptionDao;
    @Override
    public int add(FoodException exception) {
        String hash = blockChainDAO.store(exception);
        FoodExceptionHash foodExceptionHash = new FoodExceptionHash(exception.getIdentificationCode(),exception.getType(),exception.getLot(),hash,exception.getRecordTime());
        foodExceptionDao.addItem(foodExceptionHash);
        return 1;
    }

    @Override
    public List<FoodException> getAllException(String key) {
        List<FoodExceptionHash> list = foodExceptionDao.queryItemById(key);
        return null;
    }
}
