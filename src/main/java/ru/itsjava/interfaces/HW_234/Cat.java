package ru.itsjava.interfaces.HW_234;

public class Cat implements Walkable, Swimable, Runnable {

    @Override
    public void walk() {
        System.out.println( "Любит гулять" );

    }

    @Override
    public void swim() {
        System.out.println( "Моя кошка плавать не желает" );

    }

    @Override
    public double maxSwimSpeed() {
        return 0;
    }

    @Override
    public void run() {
        System.out.println( "Эта кошка быстро бегает" );

    }

    @Override
    public int maxRunDistance() {
        return 0;
    }
}
