package ru.itsjava.HW_238.oopPracticeFigure;

public class Circle extends Figure {

    public Circle(double rad) {
//        super(rad);
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
