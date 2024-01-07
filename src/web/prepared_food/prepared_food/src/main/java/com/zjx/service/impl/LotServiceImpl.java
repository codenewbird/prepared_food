package com.zjx.service.impl;

import com.zjx.dao.LotDao;
import com.zjx.entity.ProductionLot;
import com.zjx.service.LotService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 周锦兴
 */
@Service
public class LotServiceImpl implements LotService {
    @Resource
    private LotDao lotDao;
    @Override
    public int addLot(ProductionLot lot) {
        return lotDao.addItem(lot);
    }

    @Override
    public List<ProductionLot> getAllLots() {
        return lotDao.getAllItems();
    }
}
