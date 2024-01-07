package com.zjx.controller;

import com.zjx.entity.ProductionLot;
import com.zjx.service.LotService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 周锦兴
 */
@RestController
@RequestMapping("lot")
public class LotController {
    @Resource
    private LotService lotService;
    @PostMapping("add")
    public int addLot(@RequestBody ProductionLot lot){
        return lotService.addLot(lot);
    }

    @GetMapping("getAllLot")
    public ResponseEntity<List<ProductionLot>> getAllLot(){
        return ResponseEntity.ok().body(lotService.getAllLots());
    }
}
