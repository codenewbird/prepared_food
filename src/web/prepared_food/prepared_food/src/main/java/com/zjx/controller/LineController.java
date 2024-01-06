package com.zjx.controller;

import com.zjx.entity.ProductionLine;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周锦兴
 */
@RestController
@RequestMapping("line")
public class LineController {
    @PostMapping("add")
    public int addLine(@RequestBody ProductionLine line){

        return 1;
    }
}
