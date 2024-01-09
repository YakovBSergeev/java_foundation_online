package ru.itsjava.interfaces.HW_234;

public class Dog implements Walkable, Swimable, Runnable {

    @Override
    public void walk() {
        System.out.println( "Песик любит гулять" );

    }

    @Override
    public void swim() {
        System.out.println( "Собака плавает по собачьи" );

    }

    @Override
    public double maxSwimSpeed() {
        return 0;
    }

    @Override
    public void run() {
        System.out.println( "Щенки бегают неуклюже" );

    }

    @Override
    public int maxRunDistance() {
        return 0;
    }
}
