package ru.itsjava.examples.palindrome;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "введите строку: " );
        String str = scanner.nextLine();
        boolean palidrome = false;
        int j = str.length();

        for (int i = 0; i < str.length(); i++, j--) {
            if (str.charAt( i ) == str.charAt( j - 1 )) {
                palidrome = true;
            } else {
                palidrome = false;
                System.out.println( "это не палиндром" );
                break;
            }
        }
        if (palidrome == true) {
            System.out.println( "это палиндром" );
        }
        System.out.println( "asd".compareTo( "dsa" ) );

    }
}
