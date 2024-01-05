package com.zjx.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjx.entity.FoodInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author 周锦兴
 */
@RestController
@RequestMapping("food")
public class FoodInfoController {
    @PostMapping("add")
    public ResponseEntity<FoodInfo> addFood(@RequestBody FoodInfo foodInfo) throws JsonProcessingException {
        System.out.println("addSuccess");

        return ResponseEntity.ok().body(null);
    }

    @RequestMapping("testPost")
    public int testPost(@RequestBody Integer num){
        System.out.println("Hi");
        return 1;
    }

    @GetMapping("test")
    public ResponseEntity<FoodInfo> test() throws JsonProcessingException {
        System.out.println("HI");
        return ResponseEntity.ok().body(null);
    }
}
