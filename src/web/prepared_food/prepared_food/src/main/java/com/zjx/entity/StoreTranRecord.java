package com.zjx.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 周锦兴
 */
public class StoreTranRecord implements Serializable {
    private String lot;
    private Date recordTime;
    private Float temperature;
    private Float humidity;
    private Float oxygenContent;
    private int state;
    // state 为 1 表示入库，2表示出库，3表示在运输中，0表示在库中，
    private String location; //当前地点，或存储地点
}
