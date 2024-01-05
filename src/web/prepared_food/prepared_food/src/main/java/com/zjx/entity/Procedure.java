package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 周锦兴
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Procedure implements Serializable {
    private String identificationCode;
    private int rank;
    private String description;
    private String monitorPointId;
}
