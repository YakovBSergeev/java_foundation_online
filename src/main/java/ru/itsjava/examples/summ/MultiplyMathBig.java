package ru.itsjava.examples.summ;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Scanner;

@Getter
public class MultiplyMathBig {
    BigDecimal multiply = new BigDecimal( String.valueOf( 1 ) );

    public BigDecimal multiply() {
        int N;
        Scanner count = new Scanner( System.in );
        System.out.println( "Введите количество чисел для вычисления умножения:" );
        N = count.nextInt();
        System.out.println( "Введите числа для вычисления умножения:" );
        for (int i = 0; i < N; i++) {
            BigDecimal a = count.nextBigDecimal();
            multiply = multiply.multiply( a );
        }
        System.out.println( "Умножение чисел: " + multiply );
        return multiply;

    }

    @Override
    public String toString() {
        return String.valueOf( new BigDecimal( String.valueOf( getMultiply() ) ) );
    }

}
