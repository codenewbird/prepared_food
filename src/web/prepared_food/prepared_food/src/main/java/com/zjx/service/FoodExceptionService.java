package com.zjx.service;

import com.zjx.entity.FoodException;

import java.util.List;

public interface FoodExceptionService {
    int add(FoodException exception);
    List<FoodException> getAllException(String key);
}
