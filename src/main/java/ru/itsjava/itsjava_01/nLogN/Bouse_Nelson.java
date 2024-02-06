package ru.itsjava.nLogN;

import java.util.Arrays;

public class Bouse_Nelson {
    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 9, 1, 3, 7, 8, 0};
        int[] arraySort = new int[array.length];
        System.out.println("Исходный массив: " + Arrays.toString(array));
        int i1 = 1, n = 2;////////
        while (i1 <= (array.length / n)) {
            int i = 0, j = 0, k = 0, m = 1, n1 = 2;
            while (m <= array.length / n) {/////////
                for (int l = 0; l < n / 2; l++) {
                    if (array[i] > array[array.length / 2 + j]) { // Сравнивает элементы из первой и второй половины массива.
                        arraySort[k] = array[array.length / 2 + j]; // Если во второй половине меньше, присваивает новому массиву.
                        k++; // Увеличение индекса нового массива.
                        j++; // Увеличение индекса второй половины массива.
                    } else {
                        arraySort[k] = array[i]; // Если элемент в первой половине меньше, присваиваем его новому массиву.
                        k++; // Увеличение индекса нового массива.
                        i++; // Увеличение индекса первой половины массива.
                    }
                }
                for (int l = 0; l < n / 2; l++) {
                    if ((i == array.length / 2 - 1) && j < array.length / 2) {
                        arraySort[k] = array[array.length / 2 + j];
                        k++;
                        j++;
                    }
                    if ((j == array.length / 2 - 1) && i < array.length / 2) {
                        arraySort[k] = array[i];
                        k++;
                        i++;
                    }
                    if (i < array.length / 2 && j < array.length / 2 && array[i] < array[array.length / 2 + j]) {
                        arraySort[k] = array[i];
                        k++;
                        i++;
                    }
                    if (i < array.length / 2 && j < array.length / 2 && array[i] > array[array.length / 2 + j]) {
                        arraySort[k] = array[array.length / 2 + j];
                        k++;
                        j++;
                    }


                }

                m++;
            }
            array = arraySort;
            arraySort = new int[array.length];
            n = 2 * n;
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(array));

    }
}