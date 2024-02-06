package ru.itsjava.car;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Car {

    private String brandCar;
    private String colorCar;
    public static double priceCar = 1000.65485;

    public void carInfo(){
        System.out.println("brandCar+colorCar+priceCar = " + brandCar + colorCar + priceCar);

    }

}
