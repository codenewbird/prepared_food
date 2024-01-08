package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 周锦兴
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StoreTranRecord implements Serializable {
    private String lot;
    private Timestamp recordTime;
    private float temperature;
    private float humidity;
    private float oxygenContent;
    private int state;
    private int warehouseId;
    private int carId;
}
