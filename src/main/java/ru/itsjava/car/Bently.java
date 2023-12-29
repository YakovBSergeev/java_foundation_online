package ru.itsjava.car;

public class Bently extends Car {
    public Bently(String brandCar, String colorCar, double priceCar) {
        super( brandCar, colorCar );

    }

    public void carInfoB() {
        System.out.println( getBrandCar() + " цвет " + colorCar + " цена " + priceCar );
    }

}
