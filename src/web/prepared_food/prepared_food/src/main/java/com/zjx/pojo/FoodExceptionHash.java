package com.zjx.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodExceptionHash {
    private String identificationCode;
    private int type;// (1原料异常2，生产过程异常，3存储运输异常,4用户反馈异常)
    private String lot;
    private String hash;
    private Timestamp recordTime;
}
