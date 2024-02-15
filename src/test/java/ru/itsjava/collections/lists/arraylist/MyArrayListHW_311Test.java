package ru.itsjava.collections.lists.arraylist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListHW_311Test {
    MyArrayListHW_311 array = new MyArrayListHW_311();

    @Test
    void shouldCorrectlyIsEmpty() {
        array.add( 25 );
        assertFalse( array.isEmpty() );
        array.clear();
        assertTrue( array.isEmpty() );
    }

    @Test
    void shouldCorrectlyContainsFromObject() {
        array.add( 25 );
        array.add( 16 );
        assertTrue( array.contains( 16 ) );
        assertFalse( array.contains( 'A' ) );
    }

    @Test
    void shouldCorrectlySize() {
        assertEquals( 0, array.size() );
        array.add( 0 );
        array.add( "0" );
        array.add( '0' );
        assertEquals( 3, array.size() );
    }

    @Test
    void shouldCorrectlyAddFromObject() {
        assertTrue( array.add( 25 ) );
        assertEquals( true, array.contains( 25 ) );

    }

    @Test
    void shouldCorrectlyRemoveFromObject() {
        array.add( "заяц" );
        array.add( "волк" );
        array.add( "лиса" );
        assertTrue( array.remove( "волк" ) );
        assertFalse( array.remove( "122" ) );
        assertEquals( false, array.contains( "волк" ) );
    }

    @Test
    void shouldCorrectlyClear() {
        array.add( 2 );
        array.add( 2 );
        array.add( 2 );
        array.clear();
        assertEquals( 0, array.size() );
        System.out.println( "array = " + array );
    }

    @Test
    void shouldCorrectlyGetFromIndex() {
        array.add( 8 );
        array.add( 9 );
        array.add( 10 );
        assertEquals( 9, array.get( 1 ) );
    }

    @Test
    void shouldCorrectlySetFromIndexObject() {
        array.add( 8 );
        array.add( 9 );
        array.add( 10 );
        assertEquals( 12, array.set( 2, 12 ) );
        assertEquals( false, array.contains( 10 ) );
    }

    @Test
    void shouldCorrectlyIndexOfObject() {
        array.add( "один" );
        array.add( "два" );
        array.add( "три" );
        array.add( "четыре" );
        assertEquals( 2, array.indexOf( "три" ) );
    }

    @Test
    void shouldCorrectlyLastIndexOfObject() {
        array.add( "один" );
        array.add( "два" );
        array.add( "три" );
        array.add( "четыре" );
        array.add( "четыре" );
        array.add( "три" );
        array.add( "три" );
        assertEquals( 6, array.lastIndexOf( "три" ) );
    }

    @Test
    void shouldCorrectlyAddFromIndexObject() {
        array.add( "один" );
        array.add( "два" );
        array.add( "три" );
        array.add( 3,"правильно" );
        array.add( 1,"не_правильно" );
        array.add( 1,"не_важно" );
        assertEquals( "правильно", array.get( 5 ) );
        assertEquals( "два", array.get( 3 ) );
        assertEquals( true,array.contains( "правильно" ) );


    }

    @Test
    void shouldCorrectlyCRemoveFromIndex() {
        array.add( 1 );
        array.add( 2 );
        array.add( 3 );
        array.add( 4 );
        assertEquals( 3, array.remove( 2 ) );
        array.remove( 0 );
        assertEquals( false, array.contains( 1 ) );


    }
}