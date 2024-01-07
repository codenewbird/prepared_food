package com.zjx.controller;

import com.zjx.entity.Comment;
import com.zjx.entity.CommentRule;
import com.zjx.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author 周锦兴
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @PostMapping("setRule")
    public int setRule(@RequestBody CommentRule rule){
        return 1;
    }

    @PostMapping("add")
    public int addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return 1;
    }

}
