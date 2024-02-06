package ru.itsjava.itsjava_01.recursion;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 4, 65, 9, -22, 3, 9, 3, 12,-100};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            int kSort = 0;
            array[i] = getBubbleSort(i, kSort, array);
        }
        System.out.println(Arrays.toString(array));
    }
    private static int getBubbleSort(int i, int kSort, int[] array) {
                if (kSort == array.length - 1-i) {
            return array[i];
        } else if (array[kSort] > array[kSort + 1]) {
            int temp = array[kSort + 1];
            array[kSort + 1] = array[kSort];
            array[kSort] = temp;
            return getBubbleSort(i, (kSort + 1), array);
        } else {
            return getBubbleSort(i, (kSort + 1), array);
        }
    }
}
