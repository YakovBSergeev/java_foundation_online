package ru.itsjava.threads.lecture2;

public class TreadPracticeHW_343 {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> System.out.println( "Привет, я Runnable." );
        new Thread( runnable ).start();
        new Thread( runnable ).join();
        System.out.println( "getId runnable: " + new Thread( runnable ).getId() );

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
        Thread thread = new Thread( runDem );
        thread.setDaemon( true );
        thread.setPriority( 1 );
        System.out.println( "getPriority runDem: " + thread.getPriority() );
        System.out.println( "getId runDem: " + thread.getId() );
        System.out.println( "isDaemon runDem: " + thread.isDaemon() );
        System.out.println( "isAlive runDem: " + thread.isAlive() );
        thread.start();
//        thread.join();
        System.out.println( "isAlive runDem: " + thread.isAlive() );
        System.out.println( "isDaemon runDem: " + thread.isDaemon() );

    }

}
