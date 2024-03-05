package ru.itsjava.threads.lecture2;

public class ThreadPractice {

    public static void main(String[] args) {
        Runnable anonymousRunnable = new Runnable(){

            @Override
            public void run() {
                System.out.println("Привет из анонимного класса");
            }
        };

         anonymousRunnable.run();

         Thread thread = new Thread(anonymousRunnable);
         thread.start();


        Runnable functionalRunnable = () -> System.out.println("Привет из функционального программирования");
        new Thread(functionalRunnable).start();


//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Привет из быстрого потока");
//            }
//        }).start();


        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Привет после сна в 3 секунды");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.setDaemon(true);
        thread1.start();


    }
}
