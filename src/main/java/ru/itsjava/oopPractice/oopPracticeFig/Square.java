package ru.itsjava.oopPractice.oopPracticeFig;

public class Square extends Fig {

    public Square(double sideA) {
        this.sideA = sideA;
    }

    @Override
    public double perimeter() {
        return 4 * sideA;
    }

    @Override
    public double area() {
        return sideA * sideA;
    }
}
