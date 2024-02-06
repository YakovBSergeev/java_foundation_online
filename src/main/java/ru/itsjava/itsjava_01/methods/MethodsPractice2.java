package ru.itsjava.itsjava_01.methods;

import java.util.Arrays;

public class MethodsPractice2 {
    public static void main(String[] args) {
//        int[] array = new int[]{1, -2, 0, 3};
//        int num = 5;
//
//        arrayToZeroArray(array);
//        System.out.println(Arrays.toString(array));
//
//        num = numToZero();
//        System.out.println(num);
//
//    }
//
//    public static void arrayToZeroArray(int[] numbers) {
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = 0;
//        }
//    }
//
//    public static int numToZero() {
//        return 0;
        int[] array = new int[]{5, -8, 10, 0, -12, 15};
        System.out.println("1. Минимальное значение массива: " + getMinOfArray(array));
        getIPartOfFive(array);
        System.out.println("3. Сумма элементов массива с четными индексами: " + sumOfEvenIndex(array));
        firstElementOfFive(array);
    }


    public static int getMinOfArray(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static void getIPartOfFive(int[] numbers) {
        System.out.print("2. Элементы массива, делящиеся на 5: ");
        for (int i = 0; i < numbers.length; i++) {
            if (((numbers[i]) % (5)) == 0 && numbers[i] != 0) {
                System.out.print(numbers[i] + " ");
            }
        }
    }

    public static int sumOfEvenIndex(int[] numbers) {
        System.out.println();
        int sum = numbers[0];
        for (int i = 2; i < numbers.length; i = i + 2) {
            sum += numbers[i];
        }
        return sum;

    }

    public static void firstElementOfFive(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num % 5 == 0) {
                System.out.println("4. Первый элемент массива, делящийся на пять: " + num);
                break;
            }
        }
    }
}

