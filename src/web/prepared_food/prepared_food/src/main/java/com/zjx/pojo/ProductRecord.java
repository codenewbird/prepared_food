package com.zjx.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRecord {
    private String batch;
    private String rawMaterial_hash;
    private String ingredient_hash;
    private String nutrition_hash;
    private String baseInfo_hash;
    private String productionLine_hash;
}
