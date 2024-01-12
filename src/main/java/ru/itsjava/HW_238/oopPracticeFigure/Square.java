package ru.itsjava.HW_238.oopPracticeFigure;

public class Square extends Figure {

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
