package ru.itsjava.examples;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{546, 98, 6, 3, 0, 0, 0, 5546, 8, -4, -54, 454, 8, -54, -5, 48746465, -7, 546, 98, 6, 3, 0, 0, 0, 5546, 8, -4, -54, 454, 8, -54, -5, 48746465, -7, 546, 98, 6, 3, 0, 0, 0, 5546, 8, -4, -54, 454, 8, -54, -5, 48746465, -7, 546, 98, 6, 3, 0, 0, 0, 5546, 8, -4, -54, 454, 8, -54, -5, 48746465, -7};
        System.out.println( Arrays.toString( array ) );
        long startTimeQuick = System.nanoTime();
        quickSort( array, 0, array.length - 1 );
        long endTimeQuick = System.nanoTime();
        System.out.println( (endTimeQuick - startTimeQuick) );
        System.out.println( Arrays.toString( array ) );
        System.out.println( "индекс искомого числа: " + binSearch( array, 48746465 ) );
        int[] arrayForBubble = new int[]{546, 98, 6, 3, 0, 0, 0, 5546, 8, -4, -54, 454, 8, -54, -5, 48746465, -7, 546, 98, 6, 3, 0, 0, 0, 5546, 8, -4, -54, 454, 8, -54, -5, 48746465, -7, 546, 98, 6, 3, 0, 0, 0, 5546, 8, -4, -54, 454, 8, -54, -5, 48746465, -7, 546, 98, 6, 3, 0, 0, 0, 5546, 8, -4, -54, 454, 8, -54, -5, 48746465, -7};
        long startTimeBubb = System.nanoTime();
        bubbleSort( arrayForBubble );
        System.out.println( (System.nanoTime() - startTimeBubb) );
        System.out.println( Arrays.toString( arrayForBubble ) );
        long startshellSort = System.nanoTime();
        shellSort( array);
        System.out.println( (System.nanoTime() - startshellSort) );
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    isSorted = false;
                }
            }
        }

    }


    public static int binSearch(int[] array, int num) {
        int low = 0;
        int high = array.length - 1;
        int index = 0;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (num > array[middle]) {
                low = middle + 1;
            } else if (num < array[middle]) {
                high = middle - 1;
            } else if (num == array[middle]) {
                index = middle;
                break;
            } else index = -1;
        }
        if (high < low) {
            index = -1;
        }
        return index;
    }

    public static void quickSort(int[] array, int low, int high) {

        int middle = low + (high - low) / 2;
        int pivot = array[middle];

        int i = low, j = high;

        while (i <= j) {

            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort( array, low, j );
        }
        if (high > i) {
            quickSort( array, i, high );
        }
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
        }
    }


}


