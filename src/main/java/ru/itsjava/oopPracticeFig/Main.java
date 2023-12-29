package ru.itsjava.oopPracticeFig;

public class Main {
    public static void main(String[] args) {
        Fig triangle = new Triangle( 2.0, 3, 4 );
        Fig rectangle = new Rectangle( 3, 3.0 );
        Fig square = new Square( 4 );
        Fig circle = new Circle( 10 );


        System.out.println( "Площадь треугольника " + triangle.area() );
        System.out.println( "Площадь прямоугольника " + rectangle.area() );
        System.out.println( "Периметр квадрата " + square.perimeter() );
        System.out.println( "circle.area() = " + circle.area() );

    }
}
