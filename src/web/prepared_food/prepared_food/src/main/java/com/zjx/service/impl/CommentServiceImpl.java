package com.zjx.service.impl;

import com.zjx.dao.CommentDao;
import com.zjx.entity.Comment;
import com.zjx.entity.comment.CommentEntity;
import com.zjx.service.CommentService;
import com.zjx.util.CommentClassifyInterface;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;
    @Override
    public int addComment(Comment comment) {
        comment.setState(queryType(comment));
        commentDao.addItem(comment);
        return 0;
    }

    @Override
    public List<CommentEntity> getComment(String identificationCode) {
        return commentDao.queryList(identificationCode);
    }

    int queryType(Comment comment) {
        String text = "{\"input\": \""+comment.getUserComment()+"\"}";
        int result = CommentClassifyInterface.postText(text,"https://api-inference.modelscope.cn/api-inference/v1/models/damo/nlp_structbert_sentiment-classification_chinese-ecommerce-base");
        return result;
    }
}
