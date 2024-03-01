package com.skypro.Homework19Mockito.domain;

import lombok.Data;

@Data
public class Employee {
    private static long nextId = 1;
    private long id;
    private String name;
    private String surname;
    private Integer department;
    private Integer salary;

    public Employee(String name, String surname, Integer department, Integer salary) {
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }
}