package com.zjx.service.impl;

import com.zjx.dao.CommentDao;
import com.zjx.entity.Comment;
import com.zjx.service.CommentService;
import com.zjx.util.CommentClassifyInterface;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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

    int queryType(Comment comment) {
        String text = "{\"input\": \""+comment.getUserComment()+"\"}";
        int result = CommentClassifyInterface.postText(text,"https://api-inference.modelscope.cn/api-inference/v1/models/damo/nlp_structbert_sentiment-classification_chinese-ecommerce-base");
        return result;
    }
}
