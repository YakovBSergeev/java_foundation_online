package ru.itsjava.itsjava_01.OOP_Practice_Fig;

public class Main {
    public static void main(String[] args) {
        Fig triangle = new Triangle(2.345, 3, 4);
        Fig rectangle = new Rectangle(3, 3.3);
        Fig square = new Square(3.54);

        System.out.println("Площадь треугольника " + triangle.areaTriangle());
        System.out.println("Площадь прямоугольника " + rectangle.areaRec());
        System.out.println("Периметр квадрата " + square.perimeterSq());
    }
}
