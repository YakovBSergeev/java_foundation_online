package ru.itsjava.HW_238.oopPracticeFigure;

//@Getter
public abstract class Figure {

//    public double rad;
//    public double sideA, sideB, sideC;
    public static final double PI = 3.1415;

    public Figure() {

    }


    abstract double perimeter();

    abstract double area();


}
