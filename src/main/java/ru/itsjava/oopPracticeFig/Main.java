package ru.itsjava.oopPracticeFig;

public class Main {
    public static void main(String[] args) {
        Fig triangle = new Triangle( 2.345, 3, 4 );
        Fig rectangle = new Rectangle( 3, 3.3 );
        Square square = new Square( 4 );

        System.out.println( "Площадь треугольника " + triangle.areaTriangle() );
        System.out.println( "Площадь прямоугольника " + rectangle.areaRec() );
        System.out.println( "Периметр квадрата " + square.perimeterSq() );
        Fig circle = new Circle( 10 );
        System.out.println( "circle.areaCircle = " + ((Circle) circle).getAreaCircle() );

    }
}
