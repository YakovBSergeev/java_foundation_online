package ru.itsjava.oopPractice.oopPracticeFig;

public class Circle extends Fig {

    public Circle(double rad) {
        this.rad = rad;
    }


    @Override
    public double area() {
        return PI * rad * rad;
    }

    @Override
    public double perimeter(){

        return 2*PI*rad;
    }
}
