package ru.itsjava.HW_238_2;

public interface Eatable {

    default void eat(){
        System.out.println( "Я никого не ем." );
    }
}
