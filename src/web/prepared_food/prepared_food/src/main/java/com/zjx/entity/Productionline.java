package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Productionline {

    private String line_id;

    private String leader;
    private String leader_tel;
    private List<Equipment> equipmentList;

    private List<Employee> employeeList;

}
