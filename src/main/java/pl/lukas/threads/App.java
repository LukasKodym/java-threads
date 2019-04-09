package pl.lukas.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Główny wątek aplikacji " + Thread.currentThread().getName());

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable countdown = () -> {
            try {
                System.out.println("Wykonywany wątek (countdown) "
                        + Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    //Thread.sleep(1000); // the same as below
                    TimeUnit.MILLISECONDS.sleep( 100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable blastOff = () -> {
            System.out.println("Wykonywany wątek (blastOff) "
                    + Thread.currentThread().getName());
            System.out.println("Blast off");
        };

        executor.submit(countdown);
        executor.submit(blastOff);

        executor.shutdown();
//        executor.shutdownNow();
    }
}