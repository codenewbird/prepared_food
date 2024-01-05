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
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BaseInfo implements Serializable {
    private String identificationCode;
    private String name;
    private Date shelfLife;
    private String manufacturer;
    private String description;
    private String sqCode;
}
