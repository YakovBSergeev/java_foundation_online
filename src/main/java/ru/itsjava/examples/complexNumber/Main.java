package ru.itsjava.examples.complexNumber;

public class Main {
    public static void main(String[] args) {

        Complex complex1 = new Complex( -3, 45 );
        Complex complex2 = new Complex( 12, -19 );
        complex1.Show();
        complex2.Show();

        complex1=complex1.add( complex1,complex2 );
        complex1.Show();

    }
}
