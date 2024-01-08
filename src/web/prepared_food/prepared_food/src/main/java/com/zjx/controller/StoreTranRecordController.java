package com.zjx.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zjx.dao.StoreTranRecordDao;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class StoreTranRecordController {

    @Resource
    private StoreTranRecordDao storeTranDao;

    @RequestMapping("getStoreTranRecord")
    public String getStoreTranRecordByHash() throws UnsupportedEncodingException, JsonProcessingException {
        return "";
    }
}
