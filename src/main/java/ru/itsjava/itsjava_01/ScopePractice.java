package ru.itsjava;

public class ScopePractice {
    public static void main(String[] args) {
        int num = 5;


        num++;
        int numFromCodeBlock = 7;


        if (num >= 6) {

            System.out.println( "больше 0" );
        }
    }
}
