package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author 周锦兴
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductionLine {
    private String lineId;
    private int state;
    private String name;
    private List<Equipment> equipments;
}
