package ru.itsjava.nLogN;

import java.util.Arrays;

public class Bouse_Nelson_2 {
    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 9, 1, 3, 7, 8, 0};
        int[] arraySort = new int[array.length];
        System.out.println("Исходный массив: " + Arrays.toString(array));
        for (int i = 0; i < array.length / 2; i++) {
            int j = 0;
            if (array[i] > array[array.length / 2 + j]) {
                arraySort[j] = array[array.length / 2 + i];
            } else {
                arraySort[j] = array[i];
                arraySort[j + 1] = array[array.length / 2 + i];
            }

            array = arraySort;
            arraySort = new int[array.length];

        }
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }
}



