package ru.itsjava.threads.lecture1.HW_342;

import lombok.SneakyThrows;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class ThreadPracticeHW_342 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread("A");
        Runnable thread02 = new Thread("Q");

//        thread01.start();
        System.out.println(thread01);
//        thread01.join();
        System.out.println(thread02);
        Scanner str = new Scanner(System.in);
        String letter = str.next();
        Scanner number = new Scanner(System.in);
        int num = number.nextInt();
        for (int i = 0; i < num; i++) {
            sleep(5000);
            System.out.println(letter);
        }
    }
}
