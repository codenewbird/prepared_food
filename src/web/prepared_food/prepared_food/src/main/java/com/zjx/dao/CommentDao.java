package com.zjx.dao;

import com.zjx.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 周锦兴
 */
@Mapper
public interface CommentDao extends BaseDao<Comment>{
    @Override
    int addItem(Comment item);

    @Override
    List<Comment> queryItem(String key);
    int queryItemInHour(String key);
    int queryItemInDay(String key);
    int queryItemInWeek(String key);
}
