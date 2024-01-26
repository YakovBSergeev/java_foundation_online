package ru.itsjava.exceptions.HW_244;


public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        if (age < 0 || age > 150) {
            throw new AgeNotValidException( "!!!" );
        }
    }

}


