package com.zjx.controller;

import com.zjx.config.Record;
import com.zjx.entity.CommentRule;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author 周锦兴
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    @Resource
    Record record;
    @PostMapping("setRule")
    public int setRule(@RequestBody CommentRule rule){
        record.add();
        return 1;
    }

    @GetMapping("test")
    public int test(){
        record.add();
        return 1;
    }
}
