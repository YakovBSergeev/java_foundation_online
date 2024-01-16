package ru.itsjava.HW_238.oopPracticeFigure;

public class Triangle extends Figure {

    private double sideA, sideB, sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }


    @Override
    public double perimeter() {
        return sideA + sideB + sideC;

    }

    @Override
    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt( p * (p - sideA) * (p - sideB) * (p - sideC) );
    }

}
