package com.zjx.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zjx.dao.BlockChainDAO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BLKCController {

    @Resource
    private BlockChainDAO dao;
    @RequestMapping("getheight")
    public Integer getHeight() throws JsonProcessingException {
        Integer blkcHeight = dao.getBLKCHeight();
        return blkcHeight;
    }

    @RequestMapping("storetest")
    public Integer store() throws JsonProcessingException {
        dao.store();
        return null;
    }
}
