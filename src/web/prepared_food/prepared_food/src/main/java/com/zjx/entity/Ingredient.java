package com.zjx.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ingredient {
    private String production_batches;
    private String name;//配料名称
    private String manufacturer;//制作厂商
    private float dosage; //配料用量
    private Date manufacture_date;//生产日期

    public Ingredient(String production_batches, String name, String manufacturer, float dosage, Date manufacture_date) {
        this.production_batches = production_batches;
        this.name = name;
        this.manufacturer = manufacturer;
        this.dosage = dosage;
        this.manufacture_date = manufacture_date;
    }
}
