package ru.itsjava.car;

public class Bently extends Car {
    public Bently(String brandCar, String colorCar, double priceCar) {
        super( brandCar, colorCar );

    }

    public void carInfoB() {
        System.out.println( getBrandCar() + " цвет " + getColorCar() + " цена " + priceCar );
    }

    @Override
    public void carInfo(){
        System.out.println("priceCar+colorCar+brandCar = " + priceCar + getColorCar() + getBrandCar());

    }

}
