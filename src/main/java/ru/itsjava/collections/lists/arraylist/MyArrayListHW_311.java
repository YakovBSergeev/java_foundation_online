package ru.itsjava.collections.lists.arraylist;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data

public class MyArrayListHW_311 {
    private static final int DEFAULT_CAPASITY = 10;
    private int realSize;
    private Object[] array;

    public MyArrayListHW_311() {
        array = new Object[DEFAULT_CAPASITY];
        realSize = 0;
    }

    public int size() {
        return realSize;
    }

    public boolean isEmpty() {
        if (realSize != 0) {
            System.out.println("Размер вашего массива " + realSize);
            return false;
        } else {
            System.out.println("Ваш массив пустой");
            return true;
        }

    }

    public boolean contains(Object o) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (o.equals(array[i])) {
                count++;
            }
            continue;
        }
        if (count != 0) {
            System.out.println("Элемент " + " /" + o + "/ " + " содержиться в массиве " + count + " раз.");
            return true;
        } else {
            System.out.println("Элемента /" + o + "/ в массиве нет.");
            return false;
        }

    }

    public boolean add(Object o) {
        if (realSize == array.length) {
            Object[] rezArray = new Object[array.length * 3 / 2 + 1];
//            Копирование массива
            System.arraycopy(array, 0, rezArray, 0, array.length);
            array = rezArray;
        }
//            Вставка нашего элемента.
        array[realSize++] = o;
        return true;
    }

    public boolean remove(Object o) {
        return false;
    }

    public void clear() {
        realSize = 0;
        System.out.println("Массив очищен");
    }

    public Object get(int index) {
        return null;
    }

    public Object set(int index, Object element) {
        return null;
    }

    public void add(int index, Object element) {

    }

    public Object remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public String toString() {
//        return "MyArrayListHW_311{ " +  Arrays.toString(array) +  '}';
        StringBuilder stringBuilder = new StringBuilder("MyArrayListHW_311{ ");
        for (int i = 0; i < realSize; i++) {
            stringBuilder.append(array[i]).append(" ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
