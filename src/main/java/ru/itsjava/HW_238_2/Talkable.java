package ru.itsjava.HW_238_2;

public interface Talkable {

    default void talk(){
        System.out.println( "Поговори со мной!" );
    }

}
