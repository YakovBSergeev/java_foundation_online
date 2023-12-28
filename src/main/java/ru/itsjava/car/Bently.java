package ru.itsjava.car;

public class Bently extends Car {
    public Bently(String brandCar, String colorCar, double priceCar) {
        super( brandCar, colorCar, priceCar );

    }

    public void carInfoB() {
        System.out.println( brandCar +" цвет "+ colorCar +" цена "+ priceCar );
    }

}
