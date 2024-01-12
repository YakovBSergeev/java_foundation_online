package ru.itsjava.HW_238.oopPracticeFigure;

public class Rectangle extends Figure {

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

