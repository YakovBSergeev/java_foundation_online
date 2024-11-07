package ru.itsjava.examples.arrayDeletEntry;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] q = {2, 5, 4, 4, 5, 6, 6, 84, 654, 897, 65, 8, 98, 85, 8, 4, 6, 8};
        deleteEntry( q, 6 );

    }
/*удаляет из массива заданное вхождение*/
    public static void deleteEntry(int[] array, int num) {
        int off = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                off++;
            } else {
                array[i - off] = array[i];
            }
        }
        System.out.println( Arrays.toString( Arrays.copyOf( array, array.length - off ) ) );
    }
}
