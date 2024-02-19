package ru.itsjava.collections.lists.linkedlist.HW_314;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListHW_314Test {
    MyLinkedListHW_314 list = new MyLinkedListHW_314();

    @Test
    void shouldCorrectlySize() {

        list.add(0);
        list.add("0");
        list.add('0');
        assertEquals(3, list.size());
    }

    @Test
    void shouldCorrectlyIsEmpty() {
        list.add(25);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldCorrectlyContainsFromObject() {
        list.add(25);
        list.add(16);
        assertTrue(list.contains(16));
        assertFalse(list.contains('A'));
    }

    @Test
    void shouldCorrectlyAddFromObject() {
        list.add(25);
        assertEquals(true, list.contains(25));

    }

    @Test
    void shouldCorrectlyRemoveFromObject() {
        list.add("заяц");
        list.add("волк");
        list.add("лиса");
        assertTrue(list.remove("волк"));
        assertFalse(list.remove("122"));
        assertEquals(false, list.contains("волк"));
    }

    @Test
    void shouldCorrectlyClear() {
        list.add(2);
        list.add(2);
        list.add(2);
        list.clear();
        System.out.println("list.size() = " + list.size());
        assertFalse(list.contains(2));

    }

    @Test
    void shouldCorrectlyGetFromIndex() {
        list.add(8);
        list.add(9);
        list.add(10);
        assertEquals(9, list.get(1));
    }

    @Test
    void shouldCorrectlySetFromIndexObject() {
        list.add(8);
        list.add(9);
        list.add(10);
        assertEquals(12, list.set(2, 12));
        assertEquals(false, list.contains(10));
    }

    @Test
    void testAdd() {
    }

    @Test
    void shouldCorrectlyCRemoveFromIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(3, list.remove(2));
        list.remove(0);
        assertEquals(false, list.contains(1));


    }

    @Test
    void shouldCorrectlyIndexOfObject() {
        list.add("один");
        list.add("два");
        list.add("три");
        list.add("четыре");
        assertEquals(2, list.indexOf("три"));
    }

    @Test
    void shouldCorrectlyLastIndexOfObject() {
        list.add("один");
        list.add("два");
        list.add("три");
        list.add("четыре");
        list.add("четыре");
        list.add("три");
        list.add("три");
        assertEquals(6, list.lastIndexOf("три"));
    }
}