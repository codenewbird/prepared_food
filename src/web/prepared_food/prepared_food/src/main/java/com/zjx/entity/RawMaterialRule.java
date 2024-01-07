package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 周锦兴
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RawMaterialRule implements Serializable {
    private String identificationCode;
    private boolean isCheckTem;
    private boolean isCheckHum;
    private boolean isCheckOxy;
    private float maxTem;
    private float minTem;
    private float maxHum;
    private float minHum;
    private float maxOxy;
    private float minOxy;
}
