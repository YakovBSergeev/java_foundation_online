package ru.itsjava;

import java.util.Scanner;

public class ifPractice {
    public static void main(String[] args) {
        System.out.println("if Practice");
        Scanner console = new Scanner(System.in);
        System.out.println("Введите целое число");
        int numFromConsole = console.nextInt();
        System.out.println("Начало");
        if (numFromConsole > 5) {
            System.out.println("Число больше пяти");
        } else {
            System.out.println("Число меньше или равно пяти");
        }
        System.out.println("Конец");
    }

}
