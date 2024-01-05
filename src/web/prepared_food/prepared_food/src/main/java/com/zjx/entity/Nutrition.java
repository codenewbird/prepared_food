package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 周锦兴
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Nutrition implements Serializable {
    private String identificationCode;
    private String detail;

    class NT{
        String name;
        float dosage;
    }
}
