package com.zjx.service.impl;

import com.zjx.dao.EquipmentDao;
import com.zjx.dao.LineDao;
import com.zjx.entity.Equipment;
import com.zjx.entity.ProductionLine;
import com.zjx.service.LineService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 周锦兴
 */
@Service
public class LineServiceImpl implements LineService {
    @Resource
    private LineDao lineDao;
    @Resource
    private EquipmentDao equipmentDao;
    @Override
    public int addLine(ProductionLine line) {
        lineDao.addItem(line);
        for(Equipment item : line.getEquipments()){
            equipmentDao.addItem(item);
        }
        return 0;
    }

    @Override
    public List<ProductionLine> getAllLines() {
        return lineDao.getAllItems();
    }
}
