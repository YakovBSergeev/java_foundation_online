package ru.itsjava.itsjava_01;

import java.sql.SQLOutput;

public class ArrayInFor {
    public static void main(String[] args) {
//        int number = 0;
//        int[] array = new int[3]; //{1,2,3,4,5,6,7,8,9,10};
//        while (number < 4) {
//            for (int k = 0; k < 3; k++) {
//                array[k] = number + 1;
//                for (int i = 0; i < array.length; i++) {
//                    System.out.print(array[i]);
//                }
////                number++;
//            number++;
//            }
//
////        number++;
//        }
//
//        Задание_1
//        int circle = 0;
//        while (circle < 10) {
//            System.out.println("Я люблю Java!");
//            circle++;
//        }
//
////         Задание_2
        int[] array = new int[]{1, 5, 98, 6, 3};
        for (int i = 2; i < 5; i=i+2) {
//            if ((i == 2) || (i == 4)) {
                System.out.println(array[i]);
            }
        }
//
////        Задание_3
//        int length[] = new int[]{0,1,2,3,4,5,6};
//        System.out.println(length.length);
//
////        Задание_4
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Я люблю писать программы на Java");
//        }
//
////        Задание_5
//        int mass[] = new int[]{3, 5, 0, 4, -1};
//        int i = 0;
//        System.out.print("Массив: {");
//        while (i < 4) {
//            System.out.print(mass[i] + ", ");
//            i = i + 1;
//        }
//        System.out.print(mass[i] + "}"); // Как вывести на консоль кавычки?
//
//
//
//
//        int[] array = new int[]{5, 8, 10, 12, 15};
////        for (int i = 1; i < array.length; i = i + 2) {
////            System.out.print(array[i] + " ");
////        }
////        System.out.println();
//        for (int i = 0; i < 4; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
//        for (int i = array.length-4; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//
//
//
//
//
//        int[] array = new int[]{5, -8, 10, 0, -12, 15};
//        // #1
//        boolean condition = false;
//        for (int i = 0; i < array.length; i++) {
//            int k = 0;
//            while (k < array.length) {
//                if ((i + k + 1) > array.length - 1) {
//                    break;
//                } else if (array[i] <= array[i + k + 1]) {
//                    condition = true;
//                } else {
//                    condition = false;
//                    break;
//                }
//                k++;
//            }
//            if (condition == true) {
//                System.out.println("1. Минимальное значение массива: " + array[i]);
//                break;
//            }
//        }
//        if (condition == false) {
//            System.out.println("1. Минимальное значение массива: " + array[array.length - 1]);
//        }
//
//        //#2
//        System.out.print("2. Элементы массива, делящиеся на 5: ");
//        for (int i = 0; i < array.length; i++) {
//            if (((array[i]) % (5)) == 0 && array[i] != 0) {
//                System.out.print(array[i] + " ");
//            }
//        }
//        System.out.println();
//
//        //#3
//        int sumOfEvenIndex = array[0];
//        for (int i = 2; i < array.length; i = i + 2) {
//            sumOfEvenIndex = sumOfEvenIndex + array[i];
//        }
//        System.out.println("3. Сумма элементов массива с четными индексами: " + sumOfEvenIndex);
//
//        //#4
//        int firstElement;
//        for (int i = 0; i < array.length; i++) {
//            firstElement=array[i];
//            if (firstElement % 5 == 0){
//                System.out.println("4. Первый элемент массива, делящийся на пять: " + firstElement);
//                break;
//            }
//        }
    }
