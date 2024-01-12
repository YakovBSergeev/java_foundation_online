package ru.itsjava.HW_238.oopPracticeFigure;

public class Main {
    public static void main(String[] args) {
        Figure triangle = new Triangle( 2.0, 3, 4 );
        Figure rectangle = new Rectangle( 3, 3.0 );
        Figure square = new Square( 4 );
        Figure circle = new Circle( 10 );


        System.out.println( "Площадь треугольника " + triangle.area() );
        System.out.println( "Площадь прямоугольника " + rectangle.area() );
        System.out.println( "Периметр квадрата " + square.perimeter() );
        System.out.println( "circle.area() = " + circle.area() );
        System.out.println("circle.perimeter() = " + circle.perimeter());

    }
}
