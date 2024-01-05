package com.zjx.dao;

/**
 * @author 周锦兴
 */
public interface BaseDao<T> {
    int addItem(T item);
    int updateItem(T item);

    int deleteItem(T item);
}
