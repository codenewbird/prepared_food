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
public class Equipment {
    private String name;
    private String model;//型号
    private String feature;//功能
    private String manufacturer;//制作厂商
    private Date manufacture_date;
    private Date latest_overhaul_date;//最后检修日期
}
