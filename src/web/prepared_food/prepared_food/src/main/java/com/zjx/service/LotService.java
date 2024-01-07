package com.zjx.service;

import com.zjx.entity.ProductionLot;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 周锦兴
 */

public interface LotService {
    int addLot(ProductionLot lot);
    List<ProductionLot> getAllLots();
}
