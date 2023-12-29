package ru.itsjava.oopPracticeFig;

public class Triangle extends Fig {

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
