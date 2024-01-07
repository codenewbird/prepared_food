package com.zjx.controller;

import com.zjx.entity.ProductionLine;
import com.zjx.service.LineService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 周锦兴
 */
@RestController
@RequestMapping("line")
public class LineController {
    @Resource
    private LineService lineService;
    @PostMapping("add")
    public int addLine(@RequestBody ProductionLine line){
        lineService.addLine(line);
        return 1;
    }

    @GetMapping("getAllLine")
    public ResponseEntity<List<ProductionLine>> getAllLine(){
        return ResponseEntity.ok().body(lineService.getAllLines());
    }
 }
