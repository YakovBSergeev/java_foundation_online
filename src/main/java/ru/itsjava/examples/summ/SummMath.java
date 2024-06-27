package ru.itsjava.examples.summ;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class SummMath {
    int summ;

    public int summ() {
        int N;
        Scanner count = new Scanner( System.in );
        System.out.println( "Введите количество чисел для вычисления суммы:" );
        N = count.nextInt();
        System.out.println( "Введите числа для вычисления суммы:" );
        for (int i = 0; i < N; i++) {
            int a = count.nextInt();
            summ += a;
        }
        System.out.println( "Сумма чисел: " + summ );
        return summ;

    }

    @Override
    public String toString() {
        return Integer.toString( getSumm() );
    }

}
