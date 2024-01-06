package com.zjx.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 周锦兴
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductionLot {
    private String identificationCode;
    private String lot;
    private String lineId;
    private int state;
    private int num;
}
