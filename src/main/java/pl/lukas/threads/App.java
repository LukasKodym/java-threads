package pl.lukas.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture.runAsync(
                () -> System.out.println("Wątek: " + Thread.currentThread().getName())
        );

        CompletableFuture.supplyAsync(new Supplier<Integer>(
        ) {
            @Override
            public Integer get() {
                return null;
            }
        });

//        Callable<Integer> answerToEverything = () -> {
//            TimeUnit.SECONDS.sleep(10);
//            return 42;
//        };
//
//        Callable<Integer> anotherAnswerToEverything = () -> {
//            TimeUnit.SECONDS.sleep(13);
//            return 43;
//        };
//
//        Callable<Integer> finalToEverything = () -> {
//            TimeUnit.SECONDS.sleep(5);
//            return 44;
//        };


        executor.shutdown();
    }
}