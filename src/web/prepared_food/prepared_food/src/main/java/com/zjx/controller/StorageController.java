package com.zjx.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zjx.dao.BlockChainDAO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class StorageController {
    @Resource
    private BlockChainDAO blockChainDAO;
    @RequestMapping("getStorageRecord")
    public String getStorageRecordByHash() throws UnsupportedEncodingException, JsonProcessingException {
        String storageRecordList = blockChainDAO.getStorageRecordList();
        return storageRecordList;
    }
}
