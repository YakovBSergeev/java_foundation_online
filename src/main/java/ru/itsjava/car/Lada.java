package ru.itsjava.car;

public class Lada extends Car {
    public Lada(String brandCar, String colorCar, double priceCar) {
        super( brandCar, colorCar);
    }
    double priceCar = 12;
    public void carInfoL() {
        System.out.println( getBrandCar() +" цвет "+ getColorCar() +" цена "+ priceCar );
    }
    @Override
    public void carInfo(){
        System.out.println("priceCar+colorCar+brandCar = " + priceCar + getColorCar() + getBrandCar());

    }
}
