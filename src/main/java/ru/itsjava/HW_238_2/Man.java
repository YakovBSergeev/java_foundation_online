package ru.itsjava.HW_238_2;

public class Man implements Talkable, Eatable {

    @Override
    public void eat() {
        System.out.println( "Пора подкрепиться!" );
    }
}
