package ru.itsjava.car;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Car {

    public String brandCar;
    public String colorCar;
    public static double priceCar;


    public Car(String brandCar, String colorCar, double priceCar) {
        this.brandCar = brandCar;
        this.colorCar = colorCar;
        this.priceCar = priceCar; //@AllArgsConstructor не работает с полями static
    }

}
