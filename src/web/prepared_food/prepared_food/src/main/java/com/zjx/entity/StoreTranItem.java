package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoreTranItem {
    private String lot;
    private Timestamp recordTime;
    private float temperature;
    private float humidity;
    private float oxygenContent;
    private int state;
    private int warehouseId;
    private int carId;
}
