package ru.itsjava.car;

public class Lada extends Car {
    public Lada(String brandCar, String colorCar, double priceCar) {
        super( brandCar, colorCar, priceCar );
    }

    public void carInfoL() {
        System.out.println( brandCar +" цвет "+ colorCar +" цена "+ priceCar );
    }
}
