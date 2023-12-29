package ru.itsjava.oopPracticeFig;

public class Rectangle extends Fig {

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double perimeter() {
        return 2 * (sideA + sideB);
    }
    @Override
    public double area() {
        return sideA * sideB;
    }

}

