package com.zjx.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zjx.dao.BlockChainDAO;
import com.zjx.entity.FoodException;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

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
        FoodException exception = new FoodException("1",4,null,"abc", "abc"+"的评价过差",new Timestamp(new Date().getTime()));
        dao.store(exception);
        return null;
    }
}
