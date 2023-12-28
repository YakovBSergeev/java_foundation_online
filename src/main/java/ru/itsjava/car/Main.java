package ru.itsjava.car;

public class Main {
    public static void main(String[] args) {
        Car lada = new Lada( "жигули", "желтый", 100 );
        Car bently = new Bently( "бентли", "черный", 100000 );

        ((Bently) bently).carInfoB();
        ((Lada) lada).carInfoL();


    }

}
