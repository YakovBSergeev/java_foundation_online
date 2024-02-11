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
        int delIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(o)) {
                delIndex = i;
            }
            break;
        }
        if (delIndex == -1) {
            return false;
        } else {
            System.arraycopy(array, delIndex + 1, array, delIndex, array.length - 1 - delIndex);
            realSize--;
            return true;
        }
    }

    public void clear() {
        realSize = 0;
        System.out.println("Массив очищен");
    }

    public Object get(int index) {
        checkIndex(index);
        if (isCorrectIndex(index)) {
            return array[index];
        }
        return array[index];
    }

    public Object set(int index, Object element) {
        checkIndex(index);
        if (isCorrectIndex(index)) {
            array[index] = element;
        }
        return element;
    }

    public void add(int index, Object element) {

        if (realSize == array.length) {
            Object[] rezArray = new Object[array.length * 3 / 2 + 1];
            System.arraycopy(array, 0, rezArray, 0, array.length);
            array = rezArray;
        }
        if (index > -1 && index <= realSize) {
            realSize++;
            System.arraycopy(array, index, array, index + 1, realSize-index-1);
            array[index]=element;
        } else {
            checkIndex(index);
        }

    }

    public Object remove(int index) {
        checkIndex(index);
        Object resElement = array[index];
        if (isCorrectIndex(index)) {
            System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        }
        realSize--;
        return resElement;
    }


    private void checkIndex(int index) {
        if (!isCorrectIndex(index)) {
            throw new ArrayIndexOutOfBoundsException("Некорректный индекс");
        }
    }

    private boolean isCorrectIndex(int index) {
        if (index > -1 && index <= realSize) {
            return true;
        } else {
            return false;
        }
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
