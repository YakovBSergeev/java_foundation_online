package ru.itsjava.HW_238_2;

public class Main {
    public static void main(String[] args) {
        Plant dub = new Plant();
        System.out.println( "Plant" );
        dub.eat();
        dub.talk();

        Man man = new Man();
        System.out.println( "Man" );
        man.eat();
        man.talk();

        Cow cow = new Cow();
        System.out.println( "Cow" );
        cow.eat();
        cow.talk();
    }
}
