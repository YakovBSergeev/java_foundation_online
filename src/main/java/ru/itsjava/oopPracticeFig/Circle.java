package ru.itsjava.oopPracticeFig;

public class Circle extends Fig{
    public static final double PI = 3.1415;
    public double sideD;

    public Circle(double sideD) {
        this.sideD = sideD;
    }

    public double getAreaCircle() {
        double areaCircle = PI * sideD * sideD;
        return areaCircle;
    }
}
