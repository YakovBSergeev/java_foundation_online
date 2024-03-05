package ru.itsjava.threads.lecture2;

public class TreadPracticeHW_343 {
    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println( "Привет, я Runnable." );
        new Thread( runnable ).start();

        Runnable runDem = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println( "Привет, я проснулся после 4 секунд." );
                try {
                    Thread.sleep( 4000 );
                } catch (InterruptedException e) {
                    throw new RuntimeException( e );
                }
            }
        };
        Thread thread = new Thread(runDem);
        thread.setDaemon( true );
        thread.start();
    }

}
