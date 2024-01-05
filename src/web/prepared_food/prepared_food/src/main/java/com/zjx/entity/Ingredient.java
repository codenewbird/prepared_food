package com.zjx.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 周锦兴
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient implements Serializable {
    private String identificationCode;
    private String detail;
    class IGD{
        private String name;//配料名称
        private float dosage; //配料用量
    }
}
