package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BaseInfo {
    private String name;
    private String batch;
    private Date manufacture_date;
    private Date shelf_life;
    private String manufacturer;
    private String description;
}
