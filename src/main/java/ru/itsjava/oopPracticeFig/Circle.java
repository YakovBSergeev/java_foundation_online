package ru.itsjava.oopPracticeFig;

public class Circle extends Fig {

    public Circle(double rad) {
        this.rad = rad;
    }


    @Override
    public double area() {
        return PI * rad * rad;
    }
}
