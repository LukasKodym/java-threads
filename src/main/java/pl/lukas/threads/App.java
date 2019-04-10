package pl.lukas.threads;

import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture.runAsync(
                () -> System.out.println("Wątek: " + Thread.currentThread().getName()),
                executor
        );

        CompletableFuture<Integer> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        }, executor).thenApply(bar -> {
            System.out.println("*2 " + Thread.currentThread().getName());
            return bar * 2;
        }).thenApply(bar -> {
            System.out.println("+1 " + Thread.currentThread().getName());
            return bar + 1;
        });

        System.out.println(voidCompletableFuture.get());

        executor.shutdownNow();
    }
}