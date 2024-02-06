package ru.itsjava.itsjava_01.nLogN;

import java.util.Arrays;

public class QuickSorting {
    public static void main(String[] args) {
        int[] x = new int[]{8, 10, 3, -6, 0, 12, 4};
        System.out.println( "Исходный массив" );
        System.out.println( Arrays.toString( x ) );

        int low = 0;
        int high = x.length - 1;

        quickSort( x, low, high );
        System.out.println( "Отсортированный по возрастанию массив" );
        System.out.println( Arrays.toString( x ) );
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int pivot = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort( array, low, j );

        if (high > i)
            quickSort( array, i, high );
    }
}
