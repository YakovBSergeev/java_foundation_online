package ru.itsjava.examples.summ;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Scanner;

@Getter
public class SummMathBig {
    BigDecimal summ = new BigDecimal( String.valueOf( 0 ) );

    public BigDecimal summ() {
        int N;
        Scanner count = new Scanner( System.in );
        System.out.println( "Введите количество чисел для вычисления суммы:" );
        N = count.nextInt();
        System.out.println( "Введите числа для вычисления суммы:" );
        for (int i = 0; i < N; i++) {
            BigDecimal a = count.nextBigDecimal();
            summ = summ.add( a );
        }
        System.out.println( "Сумма чисел: " + summ );
        return summ;

    }

    @Override
    public String toString() {
        return String.valueOf( new BigDecimal( String.valueOf( getSumm() ) ) );
    }

}
