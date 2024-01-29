package ru.itsjava.collections.lists.HW_246;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private final int age;
    private String isMale;
}
