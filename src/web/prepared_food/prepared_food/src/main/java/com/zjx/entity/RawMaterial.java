package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 周锦兴
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterial implements Serializable {
    private String identificationCode;
    private String detail;

    class RMs{
        String name;
        float dosage;
    }

}
