package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class RawMaterial {
    private String production_batches;
    private String name;
    private String vendor;
    private String origin;
    private Date buy_time;
    private String storage;

    public RawMaterial(String production_batches, String name, String vendor, String origin, Date buy_time, String storage) {
        this.production_batches = production_batches;
        this.name = name;
        this.vendor = vendor;
        this.origin = origin;
        this.buy_time = buy_time;
        this.storage = storage;
    }
}
