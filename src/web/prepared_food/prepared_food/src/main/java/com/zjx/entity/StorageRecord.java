package com.zjx.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class StorageRecord {
    private String production_batches;
    private String storage_mode;
    private String time;
    private Float temperature;
    private Float humidity;
    private Float oxygen_content;
    private int state;
    // state 为 1 表示入库，2表示出库，3表示在运输中，0表示在库中，
    private String location; //当前地点，或存储地点

    public StorageRecord(String production_batches, String storage_mode, String time, Float temperature, Float humidity, Float oxygen_content, int state, String location) {
        this.production_batches = production_batches;
        this.storage_mode = storage_mode;
        this.time = time;
        this.temperature = temperature;
        this.humidity = humidity;
        this.oxygen_content = oxygen_content;
        this.state = state;
        this.location = location;
    }
}
