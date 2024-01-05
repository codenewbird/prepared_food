package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author 周锦兴
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Equipment {
    private String lineId;
    private String equipmentId;
    private String name;
    private String model;//型号
    private String feature;//功能
    private String manufacturer;//制作厂商
    private Date manufactureDate;//
    private Date latestOverhaulDate;//最后检修日期
}
