package ru.itsjava.recursion;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Fibonachchi {
    public static void main(String[] args) {

        int num1 = 1;
        int num2 = 2;
        long[] arrayFib = new long[93];
        arrayFib[0] = 1;
        arrayFib[1] = 1;
        for (int i = 2; i < arrayFib.length; i++) {
            arrayFib[i] = arrayFib[i - 2] + arrayFib[i - 1];
            if (arrayFib[i] < 0) {
                break;
            }
        }

        int positionStart = 0;
        int positionEnd = arrayFib.length;
        int fib12 = 144;
        System.out.println("последовательность Фибоначчи: " + Arrays.toString(arrayFib)); // Выводится последовательность Фибоначчи в пределах возможности переменной long
        System.out.println((fibonachchiIndex(arrayFib, positionStart, positionEnd, fib12) + 1) + " элемент последовательности Фибоначчи: " + fib12); // Нахождение номера последовательности Фибоначчи числа 144

        System.out.println("Введите число от 1 до 93"); // После 50 элемента последовательности Фибоначчи расчет методом рекурсии очень длителен
        Scanner console = new Scanner(System.in);
        int num = console.nextInt();
        System.out.println(num + " элемент последовательности Фибоначчи равен: " + getFib(num)); // выводит число последовательности Фибоначчи алгоритм рекурсия

        System.out.println("1000-ый элемент последовательности Фибоначчи равен: " + getFibonacciByIndexInfinite(new BigInteger("1000"))); // BigInteger
    }

    private static int fibonachchiIndex(long[] arrayFib, int positionStart, int positionEnd, int fib12) { //Определяем позицию числа в массиве.
        int midlPosition = positionStart + (positionEnd - positionStart) / 2;
        if ((fib12 == arrayFib[midlPosition])) {
            return midlPosition;
        } else if ((fib12 > arrayFib[midlPosition])) {
            return fibonachchiIndex(arrayFib, midlPosition + 1, positionEnd, fib12);
        } else {
            return fibonachchiIndex(arrayFib, positionStart, midlPosition - 1, fib12);
        }
    }


    private static long getFib(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return getFib(num - 1) + getFib(num - 2);
        }
    }

    public static BigInteger getFibonacciByIndexInfinite(BigInteger index) {
        if (index.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ZERO;
        }
        if (index.compareTo(BigInteger.ZERO) < 0) {
            throw new IndexOutOfBoundsException(index.toString());
        }
        var n0 = BigInteger.ZERO;
        var n1 = BigInteger.ONE;
        for (var i = BigInteger.TWO; i.compareTo(index) <= 0; i = i.add(BigInteger.ONE)) {
            var n2 = n0.add(n1);
            n0 = n1;
            n1 = n2;
        }
        return n1;
    }

}
