package ru.itsjava.examples.complexNumber;

public class Complex {
    private int real, image;

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    public void Show() {
        if (image > 0) {
            System.out.println( this.real + "+i" + this.image );
        } else {
            System.out.println( this.real + "-i" + Math.abs( this.image ) );
        }
    }

    public Complex add(Complex n1, Complex n2) {
        Complex rez = new Complex( 0, 0 );
        rez.real = n1.real + n2.real;
        rez.image = n1.image + n2.image;
        return rez;
    }
}
