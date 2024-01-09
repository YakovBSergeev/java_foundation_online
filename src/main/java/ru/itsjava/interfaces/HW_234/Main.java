package ru.itsjava.interfaces.HW_234;

public class Main {
    public static void main(String[] args) {
        Man human = new Man();
        Runnable barbos = new Dog();

        human.swim();
        human.walk();
        human.run();
        System.out.println( human.maxRunDistance() );

        barbos.run();
    }
}
