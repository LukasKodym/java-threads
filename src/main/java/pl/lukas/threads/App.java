package pl.lukas.threads;

import java.util.concurrent.*;
import java.util.function.Consumer;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture.runAsync(
                () -> System.out.println("Wątek: " + Thread.currentThread().getName()),
                executor
        );

        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        }, executor)
                .thenApply(bar -> {
                    System.out.println("*2 " + Thread.currentThread().getName());
                    return bar * 2;
                })
                .thenApply(bar -> {
                    System.out.println("+1 " + Thread.currentThread().getName());
                    return bar + 1;
                })
                .thenAccept(bar -> {
                    System.out.println("sout " + Thread.currentThread().getName());
                    System.out.println(bar);
                });

        executor.shutdownNow();
    }
}