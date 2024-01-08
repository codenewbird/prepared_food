package com.zjx.dao;

import java.util.List;

/**
 * @author 周锦兴
 */
public interface BaseDao<T> {
    int addItem(T item);
    int updateItem(T item);
    int deleteItem(T item);
    List<T> getAllItems(String key);
    List<T> getAllItems();

    List<T> queryItem(String key);
}
