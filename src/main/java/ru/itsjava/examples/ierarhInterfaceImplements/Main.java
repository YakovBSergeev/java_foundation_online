package ru.itsjava.examples.ierarhInterfaceImplements;


import java.util.ArrayList;
import java.util.Collections;

interface Shape extends Comparable<Shape> {
    double getVolume();

    @Override
    default int compareTo(Shape other) {
        return Double.compare( getVolume(), other.getVolume() );
    }
}

abstract class SolidOfRevolution implements Shape {
    protected double radius;

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Ball extends SolidOfRevolution { // конкретный класс

    @Override
    public double getVolume() {
        return Math.PI * Math.pow( radius, 3 ) * 4 / 3;
    }

    public Ball(double radius) {
        super( radius );
    }
}

class Cylinder extends SolidOfRevolution { // конкретный класс

    private double height;

    public Cylinder(double radius, double height) {
        super( radius );
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }
}

class Pyramid implements Shape {
    private double height;
    private double s; // площадь основания

    public Pyramid(double height, double s) {
        this.height = height;
        this.s = s;
    }

    @Override
    public double getVolume() {
        return height * s * 4 / 3;
    }
}


class Box implements Shape {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private double available;
    private double volume;

    public Box(double available) {
        this.available = available;
        this.volume = available;
    }

    public boolean add(Shape shape) {
        if (available >= shape.getVolume()) {
            shapes.add( shape );
            available -= shape.getVolume();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getVolume() {
        return volume;
    }

    public ArrayList<Shape> getShapes() { //Можно заменит геттером из ломбока
        return shapes;
    }


}

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball( 4.5 );
        Cylinder cylyinder = new Cylinder( 2, 2 );
        Pyramid pyramid = new Pyramid( 100, 100 );

        Box box = new Box( 1000 );

        System.out.println( box.add( ball ) ); // ok
        System.out.println( box.add( cylyinder ) ); // ok
        System.out.println( box.add( pyramid ) ); // failed

        // Sorting:
        ArrayList<Shape> shapes = box.getShapes();
        Collections.sort( shapes ); // sorted by Volume!
        System.out.println( shapes.toString() + box.getVolume() );


    }
}

