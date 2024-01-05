package com.zjx.controller;

import com.zjx.entity.RawMaterial;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RawMaterialController {
    @RequestMapping("rawMaterial")
    public ResponseEntity<RawMaterial> getRawMaterialInfo(){

        return null;
    }
}
