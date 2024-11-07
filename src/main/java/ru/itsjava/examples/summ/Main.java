package ru.itsjava.examples.summ;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

//        SummMath summMath = new SummMath();
//        summMath.summ();
//        System.out.println( "Сумма чисел: " + summMath.getSumm() );
//        System.out.println( "Сумма чисел: " + summMath.toString() );
//
//        SummMathBig summMathBig = new SummMathBig();
//        summMathBig.summ();
//        System.out.println( "Сумма чисел: " + summMathBig.getSumm() );
//        System.out.println( "Сумма чисел: " + summMathBig.toString() );
//
//        MultiplyMathBig multiplyMathBig = new MultiplyMathBig();
//        multiplyMathBig.multiply();
//        System.out.println( "Умножение чисел: " + multiplyMathBig.getMultiply() );
//        System.out.println( "умножение чисел: " + multiplyMathBig.toString() );

        FactorialMathBig factorialMathBig = new FactorialMathBig();
        factorialMathBig.factorial( );
        System.out.println( factorialMathBig.toString() );
        System.out.println( factorialMathBig );

    }
}
