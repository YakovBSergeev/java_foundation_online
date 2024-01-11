package ru.itsjava.interfaces.HW_236;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Person dima = new Person( "Дима", "Мухин", 22 );
        Person roma = new Person( "Дима", "Мухин", 12 );
        Person romal = new Person( "Рома", "Зверев", 22 );
        Person lada = new Person( "Лада", "Элова", 2 );
        Person liza = new Person( "Лиза", "Жукова", 84 );
        Person varya = new Person( "Варя", "Мохова", 18 );

        Person[] person = {dima, romal, roma, lada, liza, varya};

        System.out.println( "dima.compareTo( roma ) = " + dima.compareTo( roma ) );
        System.out.println( "dima.compareTo( dima ) = " + dima.compareTo( dima ) );
        System.out.println( "dima.compareTo( varya ) = " + dima.compareTo( varya ) );
        System.out.println( "liza.compareTo( varya ) = " + liza.compareTo( varya ) );

        System.out.println( Arrays.toString( person ) );
        Arrays.sort( person );
        System.out.println( Arrays.toString( person ) );

        Person lizaNext = (Person) liza.clone();
        System.out.println( lizaNext );
        System.out.println( liza );

        person = new Person[]{dima, romal, roma, lada, liza, varya, lizaNext};
        Arrays.sort( person );
        System.out.println( Arrays.toString( person ) );

    }


}
