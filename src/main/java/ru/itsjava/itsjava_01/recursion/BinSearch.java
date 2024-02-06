package ru.itsjava.itsjava_01.recursion;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class BinSearch {
    public static void main(String[] args) {

        int minBound = -10;
        int maxBound = +10;
        int random_1 = (int) (Math.random() * (maxBound - minBound + 1) + minBound); //Задаем число, которое нужно найти в массиве.
        int random_2 = (int) (Math.random() * (maxBound - minBound + 1) - minBound / 4); //Задаем длинну массива.


        int num = random_1, i = 0;
        int[] array = new int[random_2];//Заполняем массив.
        while (i < array.length) {
            array[i] = (i - (((array.length - 1) / 2) + 2)) + i * 2;
            i++;
        }

        int positionStart = 0;  //Начальная позиция поиска индекса числа в массиве.
        int positionEnd = array.length - 1; //Конечная позиция поиска индекса числа в массиве.
        boolean condition = false; // Начальное условие для поиска числа в массиве.

        //Вывод результата.
        System.out.println("Массив: " + Arrays.toString(array) + " состоит из " + random_2 + " чисел.");
        boolean search = searchNumInArray(num, positionStart, array, condition);
        if (search == true) {
            System.out.println("Число " + array[binarySearchIndex(search, num, positionStart, positionEnd, array)] + " в массиве под индексом " + binarySearchIndex(search, num, positionStart, positionEnd, array) + ".");
        } else {
            System.out.println("Числа " + num + " нет в массиве.");
        }

    }

    private static int binarySearchIndex(boolean search, int num, int positionStart, int positionEnd, int[] array) { //Определяем позицию числа в массиве.
        int midlPosition = positionStart + (positionEnd - positionStart) / 2;
        if ((search == true) && (num == array[midlPosition])) {
            return midlPosition;
        } else if ((search == true) && (num > array[midlPosition])) {
            return binarySearchIndex(search, num, midlPosition + 1, positionEnd, array);
        } else if ((search == true) && (num < array[midlPosition])) {
            return binarySearchIndex(search, num, positionStart, midlPosition - 1, array);
        } else {
            return -1;
        }
    }

    private static boolean searchNumInArray(int num, int positionStart, int[] array, boolean condition) { //Определяем истинность/ложность нахождения числа в массиве.
        if (positionStart == array.length) {
            condition = false;
            return condition;
        } else if (array[positionStart] == num) {
            condition = true;
            return condition;
        } else {
            return searchNumInArray(num, positionStart + 1, array, condition);
        }
    }
}


