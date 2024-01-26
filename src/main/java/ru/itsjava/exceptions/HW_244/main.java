package ru.itsjava.exceptions.HW_244;

import lombok.ToString;

public class main {


    public static void main(String[] args) {

        try {
            Person dimas = new Person( "Димас", -25 );
        } catch (AgeNotValidException ae) {
            System.out.println( "Ошибка возраста!!!" );
            ae.printStackTrace();
        } finally {

        }

    }
}
