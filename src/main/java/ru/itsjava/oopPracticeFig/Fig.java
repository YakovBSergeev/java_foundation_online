package ru.itsjava.oopPracticeFig;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Fig {
//    public double areaCircle;
    private double sideA;
    private double sideB;
    private double sideC;

    public Fig(){

    }

    public Fig(double sideA) {
        this.sideA = sideA;
    }

    public Fig(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

//    public Fig(double sideA, double sideB, double sideC) {
//        this.sideA = sideA;
//        this.sideB = sideB;
//        this.sideC = sideC;
//    }

    public double perimeterRec() {
        double perimeter = 2 * (sideA + sideB);
        return perimeter;
    }

    public double areaRec() {
        double area = sideA * sideB;
        return area;
    }

    public double perimeterSq() {
        double perimeter = 4 * sideA;
        return perimeter;
    }

    public double areaSq() {
        double area = sideA * sideA;
        return area;
    }

    public double perimeterTriangle() {
        double perimeterTriangle = sideA + sideB + sideC;
        return perimeterTriangle;
    }

    public double areaTriangle() {
        double p = perimeterTriangle() / 2;
        double areaTriangle = Math.sqrt( p * (p - sideA) * (p - sideB) * (p - sideC) );
        return areaTriangle;
    }
}
