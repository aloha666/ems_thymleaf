package com.springb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp {

    private String id;
    private String name;
    private Double salary;
    private int workyear;
    private Date bir;
}