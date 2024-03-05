package ru.itsjava.threads.lecture1.HW_342;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class ThreadPracticeHW_342 {

    @AllArgsConstructor
    @Data
    public static class WriteRunnable implements Runnable {
        private final String word;

        @Override
        @SneakyThrows
        public void run() {
            for (int i = 0; i < 3; i++) {
                sleep( i * 1000 );
                System.out.println( word );
            }
        }
    }

    @AllArgsConstructor
    public static class WriteTread extends Thread {
        private final String word;

        @Override
        @SneakyThrows
        public void run() {
            for (int i = 0; i < 3; i++) {
                sleep( i * 500 );
                System.out.println( word );
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WriteTread thread01 = new WriteTread( "A" );
        WriteRunnable writeRunnable = new WriteRunnable( "Q" );
        Thread thread02 = new Thread( writeRunnable );
        thread01.start();
        thread02.start();
        thread02.join();

        System.out.println( "Введите сообщение:" );
        Scanner str = new Scanner( System.in );
        String letter = str.next();
        System.out.println( "Укажите количество повторений:" );
        Scanner number = new Scanner( System.in );
        int num = number.nextInt();
        for (int i = 0; i < num; i++) {
            sleep( 5000 );
            System.out.println( letter );
        }
    }


}