package ru.itsjava.car;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Car {

    private String brandCar;
    public String colorCar;
    public static double priceCar = 1000.65485;

}
