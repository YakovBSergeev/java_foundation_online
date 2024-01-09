package ru.itsjava.interfaces.HW_234;

public class Fish implements Swimable {


    @Override
    public void swim() {
        System.out.println( "Все рыбы плавают" );

    }

    @Override
    public double maxSwimSpeed() {
        return 0;
    }


}
