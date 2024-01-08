package com.zjx.controller;

import com.zjx.entity.Comment;
import com.zjx.entity.CommentRule;
import com.zjx.entity.comment.CommentEntity;
import com.zjx.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{identificationCode}")
    public ResponseEntity<List<CommentEntity>> getComment(@PathVariable("identificationCode") String identificationCode){
        return ResponseEntity.ok().body(commentService.getComment(identificationCode));
    }

}
