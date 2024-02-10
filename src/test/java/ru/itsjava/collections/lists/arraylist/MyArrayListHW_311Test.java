package ru.itsjava.collections.lists.arraylist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListHW_311Test {
    MyArrayListHW_311 array = new MyArrayListHW_311();


    @Test
    void isEmpty() {
        array.add(25);
        assertFalse(array.isEmpty());
        array.clear();
        assertTrue(array.isEmpty());
    }

    @Test
    void contains() {
        array.add(25);
        assertTrue(array.contains(25));
        assertFalse(array.contains('A'));
    }
}