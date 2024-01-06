package com.zjx.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周锦兴
 */
@RestController
@RequestMapping("lot")
public class LotController {
    @PostMapping("add")
    public int addLot(){
        return 1;
    }
}
