package ru.itsjava.interfaces.HW_234;

public class Man implements Walkable, Swimable, Runnable {

    @Override
    public void walk() {
        System.out.println( "Идем на прогулку" );

    }

    @Override
    public void swim() {
        System.out.println( "Хорошо поплавали" );

    }

    @Override
    public double maxSwimSpeed() {
        return 0;
    }

    @Override
    public void run() {
        System.out.println( "Немного пробежались" );

    }

    @Override
    public int maxRunDistance() {
        return 0;
    }
}
