package ru.itsjava.exceptions.HW_244;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
@AllArgsConstructor

public class Person {
    private String name;
    private int age;

    public void ageExcetion() {

        if (age < 0 || age > 150) {
            try {
                System.out.println( "Ошибка возраста" );
            } catch (RuntimeException runtimeException) {
                throw new AgeNotValidException( "Ошибка возраста" );

            }

        }
        System.out.println( "name + \" \" + age = " + name + " " + age );
    }

}
