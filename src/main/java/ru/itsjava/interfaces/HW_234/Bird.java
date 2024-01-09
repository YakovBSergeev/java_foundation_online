package ru.itsjava.interfaces.HW_234;

public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println( "Не все птицы могут летать" );

    }

    @Override
    public String flyMaxDistance() {
        return null;
    }
}
