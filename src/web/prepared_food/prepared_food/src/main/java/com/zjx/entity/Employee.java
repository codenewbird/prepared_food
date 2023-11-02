package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Employee {
    private String employee_id;
    private String name;
    private String health_state;
    private String duty;
}
