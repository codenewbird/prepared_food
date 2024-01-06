package com.zjx.service;

import com.zjx.entity.ProductionLine;

import java.util.List;

/**
 * @author 周锦兴
 */
public interface LineService {
    int addLine(ProductionLine line);
    List<ProductionLine> getAllLines();
}
