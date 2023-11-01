package com.zjx.controller;

import entity.RawMaterial;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RawMaterialController {
    @RequestMapping("rawMaterial")
    public ResponseEntity<RawMaterial> getRawMaterialInfo(){
        RawMaterial rawMaterial = new RawMaterial("土豆","XXX供应商","湖南长沙",new Date(),"仓储");
        return ResponseEntity.ok().body(rawMaterial);
    }
}
