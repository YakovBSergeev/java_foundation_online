package ru.itsjava.examples.arrayRandom;
/*Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.

Для генерации случайного числа используйте метод Math.random(), который возвращает значение в промежутке [0, 1].*/
public class Main {
    public static void main(String[] args) {
        int mass = 100;
        double[] array = new double[mass];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        double max = array[0];
        double min = array[0];
        double avg = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
            avg += array[i] / array.length;
        }
        System.out.println( "max = " + max );
        System.out.println( "min = " + min );
        System.out.println( "avg = " + avg );

        /*Реализуйте алгоритм сортировки пузырьком для сортировки массива*/

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print( array[i] + " " );
        }
        for (int i = 0; i < array.length-1; i++) {
            System.out.println( array[i + 1] - array[i] );
        }

        /*Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.
*/
        for(int i = 2; i <= 100; i ++){
            boolean isPrime = true;

            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(i);
            }
        }



    }

}
