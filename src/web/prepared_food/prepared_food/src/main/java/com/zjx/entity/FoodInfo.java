package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 周锦兴
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FoodInfo implements Serializable {
    private BaseInfo baseInfo;
    private RawMaterial rawMaterial;
    private Ingredient ingredient;
    private Nutrition nutrition;
    private Procedure procedure;
}
