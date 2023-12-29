package ru.itsjava.oopPracticeFig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class Fig {
    public double rad;
    public double sideA, sideB, sideC;
    public static final double PI = 3.1415;

    public Fig() {

    }

    public double perimeter() {
        return 4 * sideA;
    }

    public double area() {
        return sideA * sideA * PI;
    }

}
