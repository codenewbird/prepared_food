package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FoodException implements Serializable {
    private String identificationCode;
    private int type;// (1原料异常2，生产过程异常，3存储运输异常,4用户反馈异常)
    private String lot;
    private String name;
    private String exceptionReason;
    private Timestamp recordTime;
}
