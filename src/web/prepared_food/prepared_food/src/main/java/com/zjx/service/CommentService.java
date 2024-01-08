package com.zjx.service;

import com.zjx.entity.Comment;
import com.zjx.entity.comment.CommentEntity;

import java.util.List;

/**
 * @author 周锦兴
 */
public interface CommentService {
    int addComment(Comment comment);
    List<CommentEntity> getComment(String identificationCode);
}
